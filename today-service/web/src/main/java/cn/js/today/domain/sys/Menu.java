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
 * @Since 2020-01-16
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-13
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_menu")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@org.hibernate.annotations.Table(appliesTo = "sys_menu", comment = "菜单表")
public class Menu extends DataEntity<Menu> {

    /**
     *  主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     *  菜单编码，唯一性，为了便于修改，故未使用ID作为关联字段
     */
    @Column(name = "menu_code", length = 100)
    private String menuCode;

    /**
     *  父级编号
     */
    @Column(name = "parent_code", length = 30)
    private String parentCode;

    /**
     * 所有父级编号
     */
    @Column(name = "parent_codes")
    private String parentCodes;

    /**
     *  本级排序号（升序）
     */
    @Column(name = "tree_sort")
    private String treeSort;

    /**
     *  所有级别排序号
     */
    @Column(name = "tree_sorts")
    private String treeSorts;

    /**
     * 是否最末级
     */
    @Column(name = "tree_leaf")
    private String treeLeaf;

    /**
     * 层次级别
     */
    @Column(name = "tree_level")
    private String treeLevel;

    /**
     * 全节点名
     */
    @Column(name = "tree_names", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '全节点名'")
    private String treeNames;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     *  菜单类型（1、横向菜单， 2、纵向菜单， 3、权限）
     */
    @Column(name = "menu_type")
    private String menuType;

    /**
     * 链接
     */
    @Column(name = "menu_href")
    private String menuHref;

    /**
     * 目标
     */
    @Column(name = "menu_target")
    private String menuTarget;

    /**
     * 图标
     */
    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     *  颜色
     */
    @Column(name = "menu_color")
    private String menuColor;

    /**
     *  菜单标题
     */
    @Column(name = "menu_title")
    private String menuTitle;

    /**
     * 权限标识
     */
    @Column(name = "permission")
    private String permission;

    /**
     *  菜单权重
     */
    @Column(name = "weight")
    private String weight;

    /**
     *  是否显示（1显示 0隐藏）
     */
    @Column(name = "is_show")
    private String isShow;

    /**
     * 归属系统（default:主导航菜单、mobileApp:APP菜单）
     */
    @Column(name = "sys_code")
    private String sysCode;

    /**
     *  归属模块（多个用逗号隔开）
     */
    @Column(name = "module_codes")
    private String moduleCodes;

    /**
     * 状态（0正常 1删除 2停用）
     */
    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
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


    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuCode='" + menuCode + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", parentCodes='" + parentCodes + '\'' +
                ", treeSort='" + treeSort + '\'' +
                ", treeSorts='" + treeSorts + '\'' +
                ", treeLeaf='" + treeLeaf + '\'' +
                ", treeLevel='" + treeLevel + '\'' +
                ", treeNames='" + treeNames + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuType='" + menuType + '\'' +
                ", menuHref='" + menuHref + '\'' +
                ", menuTarget='" + menuTarget + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuColor='" + menuColor + '\'' +
                ", menuTitle='" + menuTitle + '\'' +
                ", permission='" + permission + '\'' +
                ", weight='" + weight + '\'' +
                ", isShow='" + isShow + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", moduleCodes='" + moduleCodes + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
