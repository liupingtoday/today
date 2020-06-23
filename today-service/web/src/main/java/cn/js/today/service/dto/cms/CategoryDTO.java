package cn.js.today.service.dto.cms;

import cn.js.today.common.TreeEntity;
import cn.js.today.domain.cms.Extend;
import cn.js.today.domain.cms.Site;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-15
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-15
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class CategoryDTO extends TreeEntity<CategoryDTO> {

    @JsonIgnore
    private Long id; 	// 栏目编码

    /**
     * 用于存储之前的String类型的ID值
     */
    private String categoryId;

    private String categoryCode; 	// 栏目编码

    private String categoryName; 	// 栏目名称

    private String moduleType; 		// 模块类型

    private String image; 			// 栏目图片

    private String href; 			// 链接

    private String target; 			// 目标

    private String keywords; 		// 关键字

    private String description; 	// 描述

    private Integer inMenu; 			// 是否在导航中显示

    private Integer inList; 			// 是否在分类页中显示列表

    private Integer showModes; 		// 展现模式

    private Integer isNeedAudit; 	// 是否需要审核

    private Integer isCanComment; 	// 是否允许评论

    private Site site; 			// 扩展字段

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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
