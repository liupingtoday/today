package cn.js.today.domain;

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
@Table(name = "cc_category")
public class Category {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 	// 栏目编码

    @Column(name = "category_code")
    private String categoryCode; 	// 栏目编码

    @Column(name = "category_name")
    private String categoryName; 	// 栏目名称

//    @Column(name = "site")
//    private Site site; 				// 归属站点

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

    @Column(name = "in_menu")
    private String inMenu; 			// 是否在导航中显示

    @Column(name = "in_list")
    private String inList; 			// 是否在分类页中显示列表

    @Column(name = "show_modes")
    private String showModes; 		// 展现模式

    @Column(name = "is_need_audit")
    private String isNeedAudit; 	// 是否需要审核

    @Column(name = "is_can_comment")
    private String isCanComment; 	// 是否允许评论

    private Extend extend; 			// 扩展字段

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getInMenu() {
        return inMenu;
    }

    public void setInMenu(String inMenu) {
        this.inMenu = inMenu;
    }

    public String getInList() {
        return inList;
    }

    public void setInList(String inList) {
        this.inList = inList;
    }

    public String getShowModes() {
        return showModes;
    }

    public void setShowModes(String showModes) {
        this.showModes = showModes;
    }

    public String getIsNeedAudit() {
        return isNeedAudit;
    }

    public void setIsNeedAudit(String isNeedAudit) {
        this.isNeedAudit = isNeedAudit;
    }

    public String getIsCanComment() {
        return isCanComment;
    }

    public void setIsCanComment(String isCanComment) {
        this.isCanComment = isCanComment;
    }

    public Extend getExtend() {
        return extend;
    }

    public void setExtend(Extend extend) {
        this.extend = extend;
    }
}
