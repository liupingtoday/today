//package cn.js.today.service;
//
//import com.wondertek.oes.commons.utils.ResultBean;
//import com.wondertek.render.common.constant.AmeJobStatus;
//import com.wondertek.render.common.constant.AmeLogStatus;
//import com.wondertek.render.common.constant.CommonContents;
//import com.wondertek.render.common.constant.FilePathConstant;
//import com.wondertek.render.enums.PresetSourceEnum;
//import com.wondertek.render.po.*;
//import com.wondertek.render.service.*;
//import com.wondertek.render.util.AmeProjectUtil;
//import com.wondertek.render.util.AmeServerRequest;
//import com.wondertek.render.util.FileHandleRequst;
//import com.wondertek.render.util.XmlUtils.XmlUtils;
//import com.wondertek.render.util.file.JoinPath;
//import com.wondertek.render.util.sms.SmsInformUtil;
//import com.wondertek.render.vo.AmeVo.AmeTaskParams;
//import com.wondertek.render.vo.AmeVo.Manifest;
//import com.wondertek.render.vo.AmeVo.Payload;
//import com.xxl.job.core.biz.model.ReturnT;
//import com.xxl.job.core.handler.IJobHandler;
//import com.xxl.job.core.handler.annotation.JobHandler;
//import com.xxl.job.core.log.XxlJobLogger;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
///**
// * @Description 定时查询数据库中待分配的任务进行分配
// * @Author zhengheqi
// * @Date 2019/9/27 11:17
// * @Version 1.0.0
// */
//@JobHandler(value = "ameTaskHandler")
//@Component
//@Slf4j
//public class AmeTaskHandler extends IJobHandler {
//    @Autowired
//    private HostService hostService;
//    @Autowired
//    private AmeTaskService ameTaskService;
//    @Autowired
//    private VersionHostService versionHostService;
//    @Autowired
//    private SysConfigService sysConfigService;
//    @Value("${renderCloud.copy-file-back}")
//    private String copyFileCallBackUrl;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private AmeLogService ameLogService;
//    @Autowired
//    private StorageBasesService storageBasesService;
//    @Autowired
//    private AmePresetService amePresetService;
//    @Autowired
//    private SmsService smsService;
//
//    @Override
//    public ReturnT<String> execute(String param) {
//        ReturnT<String> success = ReturnT.SUCCESS;
//        SysConfig sysConfig = sysConfigService.findByKey(CommonContents.AME_MAX_NUM);
//        if (sysConfig == null) {
//            XxlJobLogger.log("请在系统参数中配置最大ame任务数量值 key:" + CommonContents.AME_MAX_NUM);
//
//            //如果没有配置,系统自动给定默认配置 最大任务数为1
//            sysConfig = new SysConfig();
//            sysConfig.setConfigKey(CommonContents.AME_MAX_NUM);
//            sysConfig.setConfigValue("1");
//            sysConfig.setEnable(1);
//            sysConfig.setCreateTime(LocalDateTime.now());
//            sysConfig.setRemarks("系统默认配置,需管理员手动更新");
//            sysConfigService.save(sysConfig);
//        }
//        Integer maxNum = Integer.valueOf(sysConfig.getConfigValue());
//        //查询AME所有空闲的节点
//        List<Hosts> rdrHosts = hostService.findAmeFreeHost(maxNum);
//        int hostSize = 1;
//        if (!CollectionUtils.isEmpty(rdrHosts)) {
//            hostSize = rdrHosts.size();
//        }
//
//        //2.查询是否有任务需要执行
//        AmeTaskParams ameTaskParams = new AmeTaskParams();
//        ameTaskParams.setJobStatus(AmeJobStatus.WAITING);
//        //升序排列任务,以保证越早提交的任务越早被执行,传入管理员账号不区分用户(平等)
//        Page<AmeTask> ameTaskList = ameTaskService.getAmeTaskList(ameTaskParams, 1, hostSize, "createTime", "asc", "admin");
//        List<AmeTask> ameTasks = null;
//        if (ameTaskList != null) {
//            ameTasks = ameTaskList.getContent();
//        }
//        if (CollectionUtils.isEmpty(ameTasks)) {
//            String msg = "no waiting AME job !";
//            XxlJobLogger.log(msg);
//            log.info(msg);
//            success.setMsg(msg);
//            return success;
//        }else if (CollectionUtils.isEmpty(rdrHosts)) {
//            String msg = "无可用节点,排队中... ";
//            XxlJobLogger.log(msg);
//            log.info(msg);
//            success.setMsg(msg);
//            return success;
//        }
//
//        //3.查询合适节点分配任务
//        for (int i = 0; i < ameTasks.size(); i++) {
//            Hosts host = null;
//            AmeTask ameTask = ameTasks.get(i);
//
//            //查询软件版本关联的启用节点
//            List<Hosts> list = versionHostService.findHostsByVersionId(ameTask.getAppVersionId());
//            if(CollectionUtils.isEmpty(list)){
//                XxlJobLogger.log("AME软件版本versionId=" + ameTask.getAppVersionId() + " 没有关联节点");
//                log.info("AME软件版本versionId=" + ameTask.getAppVersionId() + " 没有关联节点");
//            }
//            //空闲可用的节点
//            for (Hosts hostItem : list) {
//                if (hostItem.getAmeTaskNum() < maxNum) {
//                    host = hostItem;
//                    break;
//                }
//            }
//            if (host == null) {
//                XxlJobLogger.log("AME软件版本versionId=" + ameTask.getAppVersionId() + " 没有空闲可用的节点");
//                log.info("AME软件版本versionId=" + ameTask.getAppVersionId() + " 没有空闲可用的节点");
//                continue;
//            }
//
//            User user = userService.findUserByUseId(ameTask.getCreateBy());
//            //节点显示的共享文件上工程文件的绝对路径 用于复制到节点本地(需要的是工程的文件夹)
//            String sourcePath = ameTask.getSourceFilePath();
//            String sourcePathDir = sourcePath.substring(0, sourcePath.lastIndexOf("/"));
//            Long storageBaseId = user.getStorageBaseId();
//            StorageBases sb = storageBasesService.findByStorageBaseId(storageBaseId);
//            String win_input = sb.getWindowsMountPath();
//            String sourceProjectPath = JoinPath.merge(win_input, sourcePathDir);
//            String userName = user.getUserName();
//            SysConfig needCopyFile = sysConfigService.findByKey(CommonContents.NEED_COPY_PROJECTS);
//            if(needCopyFile == null || !("no".equals(needCopyFile.getConfigValue()))){
//                //没有配置或yes说明需要先复制工程文件到节点上
//                copyFiles(host,ameTask,sourceProjectPath,userName);
//            }else {
//                //不需要复制工程文件
//                //工程文件nas上的路径
//                sourceProjectPath = JoinPath.merge(win_input, sourcePath);
//                boolean result = sendAmeServer(host,ameTask,sourceProjectPath,userName,sb);
//                if(!result){
//                    continue;
//                }
//            }
//        }
//
//        return SUCCESS;
//    }
//
//    public boolean copyFiles(Hosts host, AmeTask ameTask,String sourceProjectPath,String userName){
//        //节点上工程文件的路径(共享目录下复制过来的)
//        String nodeInputPath = JoinPath.mergePath(FilePathConstant.WIN_NODE_INPUT, String.valueOf(ameTask.getAmeTaskId()), ameTask.getSourceFilePath());
//        nodeInputPath = nodeInputPath.substring(0,nodeInputPath.lastIndexOf("/"));
//        //查询节点上复制文件服务的请求地址
//        String fileHandleUrl = host.getFileHandleUrl();
//        String url = fileHandleUrl + CommonContents.COPY_FILE_PATH;
//        SysConfig callBack = sysConfigService.findByKey(CommonContents.COPY_FILE_CALLBACK_URL);
//        if(callBack != null){
//            copyFileCallBackUrl = callBack.getConfigValue() + CommonContents.COPY_BACK_PATH;
//        }
//
//        //发送到节点上复制文件
//        ResponseEntity<String> responseEntity = FileHandleRequst.send(sourceProjectPath,
//                nodeInputPath, ameTask.getAmeTaskId(), userName, url, copyFileCallBackUrl);
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        String body = responseEntity.getBody();
//        String logs = "发送复制文件任务到节点hostID:" + host.getHostId() +
//                " responseCode:" + statusCode + " body:" + body;
//        XxlJobLogger.log(logs);
//        log.info(logs);
//        ameTask.setDetails(logs);
//        if (statusCode.is2xxSuccessful() && "success".equals(body)) {
//            // 更新节点上的任务数量 +1
//            Integer taskNum = host.getAmeTaskNum();
//            // 更新任务的节点参数 记录本任务所在节点
//            ameTask.setHostId(host.getHostId());
//            ameTask.setJobStatus(AmeJobStatus.COPY);
//            ameTask.setCopyFileStartTime(LocalDateTime.now());
//            host.setAmeTaskNum(taskNum + 1);
//        } else {
//            XxlJobLogger.log("发送复制文件任务失败");
//            log.info("发送复制文件任务失败");
//            ameTask.setJobStatus(AmeJobStatus.FAILED);
//            ameTask.setAmeEndTime(LocalDateTime.now());
//
//            //短信通知
//            User user = userService.findUserByUseId(ameTask.getCreateBy());
//            String smsMessage = SmsInformUtil.getSmsMessage(ameTask);
//            String res = smsService.sendSmsMessage(user.getCellphone(), smsMessage);
//        }
//        AmeTaskLogs ameTaskLogs = new AmeTaskLogs(ameTask.getAmeTaskId(), LocalDateTime.now(), AmeLogStatus.COPY_PROJECT, logs);
//
//        hostService.saveOrUpdate(host);
//        ameLogService.saveLog(ameTaskLogs);
//        ameTaskService.saveAmeTask(ameTask);
//        return true;
//    }
//
//    public boolean sendAmeServer(Hosts host, AmeTask ameTask,String sourceProjectPath,String username,StorageBases sb){
//        AmeTaskLogs ameTaskLogs = new AmeTaskLogs();
//        Long taskId = ameTask.getAmeTaskId();
//        String sourceFilePath = ameTask.getSourceFilePath();
//        //创建输出文件名,不需要写后缀
//        Long fileName = System.currentTimeMillis();
//        //节点输出文件的路径
//        String nodeOutputPath = JoinPath.mergePath(FilePathConstant.WIN_NODE_OUTPUT, username,
//                String.valueOf(taskId), String.valueOf(fileName));
//
//        AmePresets amePresets = amePresetService.findByAmePresetId(ameTask.getAmePresetId());
//        String presetPath;
//        if (PresetSourceEnum.CUSTOM.getCode().equals(amePresets.getSource())) {
//            //自定义预设文件与工程文件位于同级目录
//            presetPath = JoinPath.mergePath(sb.getWindowsMountPath(), amePresets.getCustomPresetPath());
//        } else {
//            presetPath = amePresets.getSourcePresetPath();
//        }
//        //生成创建任务的xml
//        Manifest manifest = new Manifest();
//        manifest.setSourcePresetPath(presetPath);
//        manifest.setDestinationPath(nodeOutputPath);
//        manifest.setSourceFilePath(sourceProjectPath);
//        manifest.setOverwriteDestinationIfPresent("true");
//
//        String sequenceName = ameTask.getSequenceName();
//        if (!StringUtils.isEmpty(sequenceName)) {
//            XxlJobLogger.log("sequenceName:{}", sequenceName);
//            log.info("sequenceName:{}", sequenceName);
//            ResultBean resultBean = AmeProjectUtil.getSequenceGUID(JoinPath.mergePath(sb.getLinuxMountPath(), sourceFilePath), sequenceName);
//            if (!resultBean.isSuccess()) {
//                //创建任务时已经判断过,这里正常情况不会出现
//                ameTask.setDetails("sequenceName is not exists");
//                ameTask.setJobStatus(AmeJobStatus.FAILED);
//                ameTaskLogs = new AmeTaskLogs(ameTask.getAmeTaskId(), LocalDateTime.now(), AmeLogStatus.CREATE_AME_JOB, resultBean.getMsg());
//                ameLogService.saveLog(ameTaskLogs);
//                ameTaskService.saveAmeTask(ameTask);
//                return false;
//            }
//            String sequenceGUID = resultBean.getResult().toString();
//            XxlJobLogger.log("sequenceGUID:{}", sequenceGUID);
//            log.info("sequenceGUID:{}", sequenceGUID);
//            manifest.setSequenceGUID(sequenceGUID);
//        }
//
//        String requestXml = XmlUtils.convertToXml(manifest);
//        XxlJobLogger.log("create job xml:{}", requestXml);
//        log.info("create job xml:{}", requestXml);
//        ameTask.setJobXml(requestXml);
//
//        Payload payload = AmeServerRequest.createJob(requestXml, host.getAmeServerUrl());
//        XxlJobLogger.log("ameTaskId:{} hostId:{} ameServer response:{}", ameTask.getAmeTaskId(),host.getHostId(), payload);
//        log.info("ameTaskId:{} hostId:{} ameServer response:{}", ameTask.getAmeTaskId(),host.getHostId(), payload);
//        BeanUtils.copyProperties(payload, ameTask);
//        String jobStatus = payload.getJobStatus();
//        if (AmeJobStatus.FAILED.equals(jobStatus) || AmeJobStatus.SERVER_STATUS_OFFLINE.equals(jobStatus) || AmeJobStatus.NOT_FOUND.equals(jobStatus)) {
//            String detail = "创建ame任务失败:{" + payload.getDetails() + "}";
//            XxlJobLogger.log(detail);
//            log.info(detail);
//            ameTaskLogs = new AmeTaskLogs(taskId, LocalDateTime.now(), AmeLogStatus.AME_JOB_FAILED, detail);
//        } else {
//            ameTask.setAmeStartTime(LocalDateTime.now());
//            // 更新节点上的任务数量 +1
//            Integer taskNum = host.getAmeTaskNum();
//            // 更新任务的节点参数 记录本任务所在节点
//            ameTask.setHostId(host.getHostId());
//            host.setAmeTaskNum(taskNum + 1);
//
//            ameTaskLogs = new AmeTaskLogs(taskId, LocalDateTime.now(), AmeLogStatus.CREATE_AME_JOB, ameTask.getDetails());
//        }
//        hostService.saveOrUpdate(host);
//        ameLogService.saveLog(ameTaskLogs);
//        ameTaskService.saveAmeTask(ameTask);
//        return true;
//    }
//}
