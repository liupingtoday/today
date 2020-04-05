package cn.js.today.service;

import cn.js.today.domain.ame.Manifest;
import cn.js.today.domain.ame.Payload;
import cn.js.today.utils.XmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @Description 与ame web server交互的方法封装
 * @Author zhengheqi
 * @Date 2019/8/22 10:03
 * @Version 1.0.0
 */
//@Slf4j
public class AmeServerRequest {

    private final static Logger log = LoggerFactory.getLogger(AmeServerRequest.class);

    //用于测试
    public static void main(String[] args) throws InterruptedException {
        Manifest manifests = new Manifest();
        manifests.setSourceFilePath("D:/测试2/副本_0523.prproj");
        manifests.setDestinationPath("D:/测试2/zhq");
//        manifests.setSourcePresetPath("C:/Program Files/Adobe/Adobe Media Encoder CC 2018/MediaIO/systempresets/4E49434B_48323634/00 - Match Source - High bitrate.epr");
//        manifests.setSourcePresetPath("C:\\Program Files\\Adobe\\Adobe Media Encoder CC 2019\\MediaIO\\systempresets\\4A454646_48455643\\01 - Match Source - High Bitrate.epr");
//        manifests.setSourcePresetPath("D:\\system_presets\\h264\\00 - Match Source - High bitrate.epr");
        manifests.setOverwriteDestinationIfPresent("true");
//        manifests.setSequenceGUID("9bef954f-05fc-45cf-8d76-e7296902325f");

        //<?xml version="1.0" encoding="utf-8"?>
        //
        //<Manifest>
        //  <SourceFilePath>D:/input/1020000017/cloudrender1/uploads/ame/调色4K/第四期/第四期.prproj</SourceFilePath>
        //  <DestinationPath>D:/output/zhengheqi/1020000017/1585189111306</DestinationPath>
        //  <SourcePresetPath>D:\system_presets\h264\High Quality 1080 HD.epr</SourcePresetPath>
        //  <overwriteDestinationIfPresent>true</overwriteDestinationIfPresent>
        //  <SequenceGUID>aed70798-664d-43cc-953c-92a8847d9f27</SequenceGUID>
        //</Manifest>

        Manifest manifests3 = new Manifest();
        manifests3.setSourceFilePath("C:\\data\\testVideo\\xuanranwenjian\\fouth.prproj");
        manifests3.setDestinationPath("C:\\data\\testVideo\\xuanranwenjian\\test2");
//        manifests3.setSourcePresetPath("D:\\system_presets\\h265\\4K UHD.epr");
//        manifests3.setSourcePresetPath("C:\\data\\testVideo\\xuanranwenjian\\fouthTest.epr");
        manifests3.setSourcePresetPath("C:\\data\\testVideo\\xuanranwenjian\\YouTube720pHD.epr");
        manifests3.setOverwriteDestinationIfPresent("true");
//        manifests3.setSequenceGUID("aed70798-664d-43cc-953c-92a8847d9f27");

        Manifest manifests2 = new Manifest();
        manifests2.setSourceFilePath("z:\\第四期\\第四期.prproj");
        manifests2.setDestinationPath("z:\\第四期\\test2");
//        manifests2.setSourcePresetPath("D:\\system_presets\\h265\\fouth.epr");
        manifests2.setSourcePresetPath("C:\\Program Files\\Adobe\\Adobe Media Encoder CC 2019\\MediaIO\\systempresets\\4A454646_48455643\\01 - Match Source - High Bitrate.epr");
        manifests2.setOverwriteDestinationIfPresent("true");
        manifests2.setSequenceGUID("aed70798-664d-43cc-953c-92a8847d9f27");
        String xml = XmlUtils.convertToXml(manifests3);
        System.out.println("xml:" + xml);
//        String url = "http://192.168.107.96:8080";
//        String url = "http://192.168.1.21:8080";
        String url = "http://169.254.108.31:8080";
        Payload payload = createJob(xml, url);
        System.out.println(payload);
        System.out.println(payload.getJobId());

//        String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<!DOCTYPE payload><payload version=\"1.0\">\n" +
//                "<ServerStatus>Online</ServerStatus>\n" +
//                "<JobStatus>Encoding</JobStatus>\n" +
//                "<JobId>bdc30313-c307-450a-b7d2-c2553e722285</JobId>\n" +
//                "<JobProgress>61.49</JobProgress>\n" +
//                "<Details>Encoding source: D:\\1234\\æµ\u008Bè¯\u00952\\å\u0089¯æ\u009C¬_0523.prproj</Details>\n" +
//                "</payload>";

//        ObjectMapper objectMapper = new XmlMapper();
//        Payload payload1 = null;
//        try {
//            payload1 = objectMapper.readValue(payload, Payload.class);
//        } catch (IOException e) {
//            System.out.println(e);
//        }


//        Payload payload2 = getJob("4ae14d68-332d-4163-b967-b4061f84c2e3", url);
//        System.out.println("********************************");
//        System.out.println(payload2);
    }

    /**
     * 发送post请求到AMEServer创建任务
     *
     * @param requestXml
     * @param url        节点AME服务器的请求地址
     * @return
     */
    public static Payload createJob(String requestXml, String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType(MediaType.APPLICATION_XML, Charset.forName("UTF-8")));
        HttpEntity<String> httpEntity = new HttpEntity<>(requestXml, httpHeaders);
        //本地AMEServer url = http://192.168.107.96:8080
        RestTemplate restTemplate = getRestTemplete();
        Payload payload = new Payload();
        try {
            ResponseEntity<Payload> responseEntity = restTemplate.postForEntity(url + "/job", httpEntity, Payload.class);
            payload = getResutl(responseEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
//            payload.setJobStatus(AmeJobStatus.FAILED);
            payload.setDetails(e.getMessage());
        }
        return payload;
    }

    /**
     * get请求到AMEServer获取任务详细
     *
     * @param jobId
     * @param url
     * @return
     */
    public static Payload getJob(String jobId, String url) {
        String requestUrl = url + "/job?jobId=" + jobId;

        return requestAme(requestUrl);
    }

    /**
     * delete请求到AMEServer删除任务
     *
     * @param jobId
     * @param url
     */
    public static String deleteJob(String jobId, String url) {
        String requestUrl = url + "/job?jobId=" + jobId;
        String result = "success";
        try {
            RestTemplate restTemplate = getRestTemplete();
            restTemplate.delete(requestUrl);
            log.info("delete ameJob:{} success", jobId);
        } catch (Exception e) {
            log.info("delete ameJob:{} failed", jobId);
            log.error(e.getMessage(), e);
            result = "failed";
        }
        return result;
    }

    /**
     * 获取ameServer的状态
     *
     * @param url
     * @return
     */
    public static Payload getStatus(String url) {
        String requestUrl = url + "/server";
        return requestAme(requestUrl);
    }

    public static Payload requestAme(String requestUrl) {
        RestTemplate restTemplate = getRestTemplete();
        Payload payload = null;
        try {
            ResponseEntity<Payload> responseEntity = restTemplate.getForEntity(requestUrl, Payload.class);
            payload = getResutl(responseEntity);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return payload;
    }

    //公共方法
    public static Payload getResutl(ResponseEntity<Payload> responseEntity) {
        String code = responseEntity.getStatusCode().toString();
        Payload body = responseEntity.getBody();
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return body;
        } else {
            log.error("httpRequest error Code:{} , body:{}", code, body);
//            body.setJobStatus(AmeJobStatus.FAILED);
            body.setDetails("创建任务失败,httpRequest error Code:" + code);
            return body;
        }
    }

    public static RestTemplate getRestTemplete() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);// 设置超时
        requestFactory.setReadTimeout(10000);
        return new RestTemplate(requestFactory);
    }

}
