package cn.js.today.service.dto.sys;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class ConfigDTO {

    // Regex for acceptable configName
    public static final String NAME_REGEX = "^[_.@A-Za-z0-9-]*$";

    /**
     * 编号
     */
    @NotBlank
    @ApiModelProperty(value = "编号")
    private Long id;

    /**
     * 参数名称
     */
    @Size(min = 1, max = 50)
    @Pattern(regexp = NAME_REGEX)
    @ApiModelProperty(value = "参数名称")
    @NotNull(message = "缺少 configName 信息")
    private String configName;

    /**
     * 参数键名
     */
    @NotBlank
    @ApiModelProperty(value = "参数键名")
    private String configKey;

    /**
     * 参数键值
     */
    @ApiModelProperty(value = "参数键值")
    private String configValue;

    /**
     * 系统内置    1是 0否
     */
    @NotBlank
    @ApiModelProperty(value = "系统内置")
    @NotNull(message = "缺少 isSys 信息")
    private String isSys;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remarks;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
