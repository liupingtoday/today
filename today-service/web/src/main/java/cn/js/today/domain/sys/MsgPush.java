package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 消息推送类
 * @Author: liuping
 * @Since 2020-02-12
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-12
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_msg_push")
public class MsgPush extends DataEntity<MsgPush> {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 消息类型（PC APP 短信 邮件 微信）
     */
    @Column(name = "msg_type")
    private String msgType;

    /**
     * 消息标题
     */
    @Column(name = "msg_title")
    private String msgTitle;

    /**
     * 消息内容
     */
    @Column(name = "msg_content")
    private String msgContent;

    /**
     * 业务主键
     */
    @Column(name = "biz_key")
    private String bizKey;

    /**
     * 业务类型
     */
    @Column(name = "biz_type")
    private String bizType;

    /**
     * 接受者账号
     */
    @Column(name = "receive_code")
    private String receiveCode;

    /**
     * 接受者用户编码
     */
    @Column(name = "receive_user_code")
    private String receiveUserCode;

    /**
     * 接受者用户姓名
     */
    @Column(name = "receive_user_name")
    private String receiveUserName;

    /**
     * 发送者用户编码
     */
    @Column(name = "send_user_code")
    private String sendUserCode;

    /**
     * 发送者用户姓名
     */
    @Column(name = "send_user_name")
    private String sendUserName;

    /**
     * 发送时间
     */
    @Column(name = "send_date")
    private String sendDate;

    /**
     * 是否合并推送
     */
    @Column(name = "is_merge_push")
    private String isMergePush;

    /**
     * 计划推送时间
     */
    @Column(name = "plan_push_date")
    private String planPushDate;

    /**
     * 推送尝试次数
     */
    @Column(name = "push_number")
    private String pushNumber;

    /**
     * 推送返回结果码
     */
    @Column(name = "push_return_code")
    private String pushReturnCode;

    /**
     * 推送返回消息编号
     */
    @Column(name = "push_return_msg_id")
    private String pushReturnMsgId;

    /**
     * 推送返回的内容信息
     */
    @Column(name = "push_return_content")
    private String pushReturnContent;

    /**
     * 推送状态（0未推送 1成功  2失败）
     */
    @Column(name = "push_status")
    private String pushStatus;

    /**
     * 推送时间
     */
    @Column(name = "push_date")
    private String pushDate;

    /**
     * 读取状态（0未送达 1已读 2未读）
     */
    @Column(name = "read_status")
    private String readStatus;

    /**
     * 读取时间
     */
    @Column(name = "read_date")
    private String readDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getBizKey() {
        return bizKey;
    }

    public void setBizKey(String bizKey) {
        this.bizKey = bizKey;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getReceiveCode() {
        return receiveCode;
    }

    public void setReceiveCode(String receiveCode) {
        this.receiveCode = receiveCode;
    }

    public String getReceiveUserCode() {
        return receiveUserCode;
    }

    public void setReceiveUserCode(String receiveUserCode) {
        this.receiveUserCode = receiveUserCode;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public String getSendUserCode() {
        return sendUserCode;
    }

    public void setSendUserCode(String sendUserCode) {
        this.sendUserCode = sendUserCode;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getIsMergePush() {
        return isMergePush;
    }

    public void setIsMergePush(String isMergePush) {
        this.isMergePush = isMergePush;
    }

    public String getPlanPushDate() {
        return planPushDate;
    }

    public void setPlanPushDate(String planPushDate) {
        this.planPushDate = planPushDate;
    }

    public String getPushNumber() {
        return pushNumber;
    }

    public void setPushNumber(String pushNumber) {
        this.pushNumber = pushNumber;
    }

    public String getPushReturnCode() {
        return pushReturnCode;
    }

    public void setPushReturnCode(String pushReturnCode) {
        this.pushReturnCode = pushReturnCode;
    }

    public String getPushReturnMsgId() {
        return pushReturnMsgId;
    }

    public void setPushReturnMsgId(String pushReturnMsgId) {
        this.pushReturnMsgId = pushReturnMsgId;
    }

    public String getPushReturnContent() {
        return pushReturnContent;
    }

    public void setPushReturnContent(String pushReturnContent) {
        this.pushReturnContent = pushReturnContent;
    }

    public String getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
    }

    public String getPushDate() {
        return pushDate;
    }

    public void setPushDate(String pushDate) {
        this.pushDate = pushDate;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }
}
