package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-01-20
 * @UpdateUser: liuping
 * @UpdateDate: 2020-01-31
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_config")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Config extends DataEntity<Config> {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 参数名称
     */
    @Column(name = "config_name")
    private String configName;

    /**
     * 参数键名
     */
    @Column(name = "config_key")
    private String configKey;

    /**
     * 参数键值
     */
    @Column(name = "config_value", length = 20000)
    private String configValue;

    /**
     * 系统内置    1是 0否
     */
    @Column(name = "is_sys")
    private String isSys;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", configName='" + configName + '\'' +
                ", configKey='" + configKey + '\'' +
                ", configValue='" + configValue + '\'' +
                ", isSys='" + isSys + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime='" + updatedTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
