package cn.js.today.service.dto;

import cn.js.today.common.DataEntity;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-01-16
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-12
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class MenuDTO extends DataEntity<MenuDTO> {

    /**
     *  菜单编码
     */
    private Long menuCode;

    /**
     *  父级编号
     */
    private String parentCode;

    /**
     * 所有父级编号
     */
    private String parentCodes;

    /**
     *  本级排序号（升序）
     */
    private String treeSort;

    /**
     *  所有级别排序号
     */
    private String treeSorts;

    /**
     * 是否最末级
     */
    private String treeLeaf;

    /**
     * 层次级别
     */
    private String treeLevel;

    /**
     * 全节点名
     */
    private String treeNames;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     *  菜单类型（1菜单 2权限）
     */
    private String menuType;

    /**
     * 链接
     */
    private String menuHref;

    /**
     * 目标
     */
    private String menuTarget;

    /**
     * 图标
     */
    private String menuIcon;

    /**
     *  颜色
     */
    private String menuColor;

    /**
     *  菜单标题
     */
    private String menuTitle;

    /**
     * 权限标识
     */
    private String permission;

    /**
     *  菜单权重
     */
    private String weight;

    /**
     *  是否显示（1显示 0隐藏）
     */
    private String isShow;

    /**
     * 归属系统（default:主导航菜单、mobileApp:APP菜单）
     */
    private String sysCode;

    /**
     *  归属模块（多个用逗号隔开）
     */
    private String moduleCodes;

    /**
     * 状态（0正常 1删除 2停用）
     */
    private String status;

    public Long getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(Long menuCode) {
        this.menuCode = menuCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentCodes() {
        return parentCodes;
    }

    public void setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
    }

    public String getTreeSort() {
        return treeSort;
    }

    public void setTreeSort(String treeSort) {
        this.treeSort = treeSort;
    }

    public String getTreeSorts() {
        return treeSorts;
    }

    public void setTreeSorts(String treeSorts) {
        this.treeSorts = treeSorts;
    }

    public String getTreeLeaf() {
        return treeLeaf;
    }

    public void setTreeLeaf(String treeLeaf) {
        this.treeLeaf = treeLeaf;
    }

    public String getTreeLevel() {
        return treeLevel;
    }

    public void setTreeLevel(String treeLevel) {
        this.treeLevel = treeLevel;
    }

    public String getTreeNames() {
        return treeNames;
    }

    public void setTreeNames(String treeNames) {
        this.treeNames = treeNames;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuColor() {
        return menuColor;
    }

    public void setMenuColor(String menuColor) {
        this.menuColor = menuColor;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getModuleCodes() {
        return moduleCodes;
    }

    public void setModuleCodes(String moduleCodes) {
        this.moduleCodes = moduleCodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
