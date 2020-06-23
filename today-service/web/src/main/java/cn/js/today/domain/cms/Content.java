package cn.js.today.domain.cms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since
 * @UpdateUser: liuping
 * @UpdateDate:
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "today_cms_content")
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 内容ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contentSequenceGenerator")
    @SequenceGenerator(name = "contentSequenceGenerator")
    private Long id;

    /**
     * 内容的标题
     */
    @NotNull
    @Size(min = 2)
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * 副标题
     */
    @NotNull
    @Column(name= "subtitle", nullable = false)
    private String subtitle;

    /**
     * 内容的作者
     */
    @NotNull
    @Column(name= "author", nullable = false)
    private String author;

    /**
     * 内容的发布者
     */
    @NotNull
    @Column(name= "publisher", nullable = false)
    private String publisher;

    /**
     * 超链接地址
     */
    @Column(name= "href")
    private String href;

    /**
     * 内容的正文
     */
    @Column(name= "content")
    private String content;

    /**
     * 内容的标签
     */
    @Column(name= "tag")
    private String tag;

    /**
     * 描述
     */
    @Column(name= "description")
    private String description;

    /**
     * 内容的关键词
     */
    @Column(name= "keywords")
    private String keywords;

    /**
     *是否置顶
     */
    @NotNull
    @Column(name= "isTop", nullable = false)
    private String isTop;

    /**
     * 模板存储路径
     */
    @NotNull
    @Column(name= "template_path", nullable = false)
    private String templatePath;

    /**
     * 列的code
     */
    @NotNull
    @Column(name= "column_code", nullable = false)
    private String columnCode;

    /**
     * 删除标记
     */
    @NotNull
    @Column(name= "delete_flag", nullable = false)
    private String deleteFlag;

    /**
     * 是否推荐
     */
    @NotNull
    @Column(name= "is_recommend", nullable = false)
    private String isRecommend;

    /**
     * 是否展现
     */
    @NotNull
    @Column(name= "is_show", nullable = false)
    private String isShow;

    /**
     * 单击次数
     */
    @NotNull
    @Column(name= "clicks", nullable = false)
    private Integer clicks;

    /**
     * 封面图片的存储路径地址
     */
    @Column(name= "cover_image_url", nullable = false)
    private Integer coverImageUrl;

    /**
     * 是否需要审核
     */
    @NotNull
    @Column(name= "is_audit", nullable = false)
    private Integer isAudit;

    /**
     * 排序的序号
     */
    @NotNull
    @Column(name= "sort", nullable = false)
    private Integer sort;

    /**
     * 审核状态
     */
    @NotNull
    @Column(name= "check_status", nullable = false)
    private Integer checkStatus;

    /**
     * 备注
     */
    @Column(name= "remark")
    private String remark;

    /**
     * 内容的创建者
     */
    @NotNull
    @Column(name= "created_by", nullable = false)
    private String createdBy;

    /**
     * 创建时间
     */
    @NotNull
    @Column(name= "created_time", nullable = false)
    private LocalDateTime createdTime;

    /**
     * 内容的更新者
     */
    @NotNull
    @Column(name= "updated_by", nullable = false)
    private String updatedBy;

    /**
     * 内容的更新时间
     */
    @NotNull
    @Column(name= "updated_time", nullable = false)
    private LocalDateTime updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(Integer coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public Integer getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Content{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", subtitle='" + subtitle + '\'' +
            ", author='" + author + '\'' +
            ", publisher='" + publisher + '\'' +
            ", href='" + href + '\'' +
            ", content='" + content + '\'' +
            ", tag='" + tag + '\'' +
            ", description='" + description + '\'' +
            ", keywords='" + keywords + '\'' +
            ", isTop='" + isTop + '\'' +
            ", templatePath='" + templatePath + '\'' +
            ", columnCode='" + columnCode + '\'' +
            ", deleteFlag='" + deleteFlag + '\'' +
            ", isRecommend='" + isRecommend + '\'' +
            ", isShow='" + isShow + '\'' +
            ", clicks=" + clicks +
            ", coverImageUrl=" + coverImageUrl +
            ", isAudit=" + isAudit +
            ", sort=" + sort +
            ", checkStatus=" + checkStatus +
            ", remark='" + remark + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", createdTime=" + createdTime +
            ", updatedBy='" + updatedBy + '\'' +
            ", updatedTime=" + updatedTime +
            '}';
    }
}
