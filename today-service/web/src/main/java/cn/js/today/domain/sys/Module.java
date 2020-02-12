package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-11
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-11
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_module")
public class Module extends DataEntity<Module> {

    /**
     * 模块编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleCode;

    /**
     * 模块名称
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 模块描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 当前版本
     */
    @Column(name = "current_version")
    private String currentVersion;

    /**
     * 升级信息
     */
    @Column(name = "upgrade_info")
    private String upgradeInfo;
    /**
     * 状态（0正常 1删除 2停用）
     */
    @Column(name = "status")
    private String status;
    /**
     * 主类全名
     */
    @Column(name = "main_class_name")
    private String mainClassName;

    public Long getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(Long moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getUpgradeInfo() {
        return upgradeInfo;
    }

    public void setUpgradeInfo(String upgradeInfo) {
        this.upgradeInfo = upgradeInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMainClassName() {
        return mainClassName;
    }

    public void setMainClassName(String mainClassName) {
        this.mainClassName = mainClassName;
    }
}
