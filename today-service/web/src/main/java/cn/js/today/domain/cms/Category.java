package cn.js.today.domain.cms;

import cn.js.today.common.TreeEntity;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2019-12-14
 * @UpdateUser: liuping
 * @UpdateDate:
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "cms_category")
public class Category extends TreeEntity<Category> {

//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 	// 栏目编码

    /**
     * 用于存储之前的String类型的ID值
     */
    private String categoryId;

    @Column(name = "category_code")
    private String categoryCode; 	// 栏目编码

    @Column(name = "category_name")
    private String categoryName; 	// 栏目名称

    @Column(name = "site_code")
    private String siteCode; 		// 归属站点

    @Column(name = "module_type")
    private String moduleType; 		// 模块类型

    @Column(name = "image")
    private String image; 			// 栏目图片

    @Column(name = "href")
    private String href; 			// 链接

    @Column(name = "target")
    private String target; 			// 目标

    @Column(name = "keywords")
    private String keywords; 		// 关键字

    @Column(name = "description")
    private String description; 	// 描述

    /**
     *  是否在导航中显示, 1:显示 ， 0 隐藏
     */
    @Column(name = "in_menu")
    private Integer inMenu;

    /**
     *  是否在分类页中显示列表, 1:显示 ， 0 隐藏
     */
    @Column(name = "in_list")
    private Integer inList;

    /**
     *  展现模式
     */
    @Column(name = "show_modes")
    private Integer showModes;

    /**
     *  是否需要审核
     */
    @Column(name = "is_need_audit")
    private Integer isNeedAudit;

    /**
     * 是否允许评论
     */
    @Column(name = "is_can_comment")
    private Integer isCanComment;

    private Extend extend; 			// 扩展字段

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInMenu() {
        return inMenu;
    }

    public void setInMenu(Integer inMenu) {
        this.inMenu = inMenu;
    }

    public Integer getInList() {
        return inList;
    }

    public void setInList(Integer inList) {
        this.inList = inList;
    }

    public Integer getShowModes() {
        return showModes;
    }

    public void setShowModes(Integer showModes) {
        this.showModes = showModes;
    }

    public Integer getIsNeedAudit() {
        return isNeedAudit;
    }

    public void setIsNeedAudit(Integer isNeedAudit) {
        this.isNeedAudit = isNeedAudit;
    }

    public Integer getIsCanComment() {
        return isCanComment;
    }

    public void setIsCanComment(Integer isCanComment) {
        this.isCanComment = isCanComment;
    }

    public Extend getExtend() {
        return extend;
    }

    public void setExtend(Extend extend) {
        this.extend = extend;
    }
}
