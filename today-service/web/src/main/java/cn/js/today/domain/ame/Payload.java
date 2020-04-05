package cn.js.today.domain.ame;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author zhengheqi
 * @Date 2019/8/19 11:22
 * @Version 1.0.0
 */
//@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {
    /**
     * 服务器状态
     */
    @JacksonXmlProperty(localName = "ServerStatus")
    private String serverStatus;
    /**
     * 任务状态
     */
    @JacksonXmlProperty(localName = "JobStatus")
    private String jobStatus;
    /**
     * jobId: mediaEncoder webService创建
     */
    @JacksonXmlProperty(localName = "JobId")
    private String jobId;
    /**
     * 任务进度
     */
    @JacksonXmlProperty(localName = "JobProgress")
    private String jobProgress;
    /**
     * 详情描述
     */
    @JacksonXmlProperty(localName = "Details")
    private String details;

    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobProgress() {
        return jobProgress;
    }

    public void setJobProgress(String jobProgress) {
        this.jobProgress = jobProgress;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
