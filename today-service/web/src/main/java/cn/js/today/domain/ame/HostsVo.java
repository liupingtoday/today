package cn.js.today.domain.ame;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: WANGJING
 * @Description:
 * @Date: 2019/11/7 14:22
 * @Modifier:
 * @Version:
 * @TaskId:
 */

@Data
public class HostsVo {

    //id
    private Long hostId;

    /**
     * 节点名称
     */
    @NotBlank(message = "hostName is null", groups = {Default.class})
    private String hostName;

    /**
     * 节点ip
     */
    @NotBlank(message = "hostIp is null", groups = {Default.class})
    private String hostIp;

    /** 启用;0:否 1:是 */
    @NotBlank(message = "enable is null", groups = {Default.class})
    @Pattern(regexp = "0|1", message = "enable只能为1或0")
    private String enable ;

    /**
     * 节点类型 0:待分配 1:渲染节点 2:AME节点
     */
    @NotNull(message = "hostType is null", groups = {Default.class})
    @Range(min = 0,max = 2)
    private Integer hostType;

    /**
     * 运行的任务数量 初始为0 非负
     */
    private Integer ameTaskNum = 0;

    /**
     * 节点上AMEServer服务的请求地址;
     */

    private String ameServerUrl;

    /**
     * 节点上fileHandle文件处理(搬迁/复制)脚本的请求地址
     */
    private String fileHandleUrl;

    /**
     * 节点状态 Offline ;Online
     */
    private String hostStatus;

    /** ame服务状态;Offline ;Online */
    private String ameServerStatus ;

    /** 文件处理服务状态;Offline ;Online */
    private String fileHandleStatus ;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 修改人id
     */
    private Long updateBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 关联软件版本id集合
     */
    private List<Long> appVersionIds;

    /**
     * 更新人userName；
     */
    private String updateUserName;
}
