package cn.js.today.domain.cms;

import javax.persistence.*;
import java.util.Date;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2019-12-15
 * @UpdateUser: liuping
 * @UpdateDate: 2019-12-15
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
//@Entity
//@Table(name = "sys_image")
public class Image {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 图片的ID
     */
    @Column(name = "img_id")
    private String imgId;

    /**
     *  业务的主键
     */
    @Column(name = "biz_key")
    private String bizKey;

    /**
     *  业务的类型
     */
    @Column(name = "biz_type")
    private String bizType;

    /**
     * 图片的名称
     */
    @Column(name = "name")
    private String name;

    /**
     *  图片类型
     *
     *  表示图片真实的文件格式
     *
     * 1、jpg
     *
     * 2、png
     *
     * 3、gif
     *
     * 4、ico
     *
     * 5、webp
     */
    @Column(name = "type")
    private String type;

    /**
     *  图片的状态
     */
    @Column(name = "status")
    private String status;

    /**
     *  图片的描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 图片的标签
     */
    @Column(name = "tag")
    private Integer tag;


    /**
     *  图片的类型   1：图片、2：图册
     */
    @Column(name = "category")
    private String category;


    /**
     *  图片在图册中的排序
     */
    @Column(name = "sort")
    private Date sort;

    /**
     * 图片的来源
     */
    @Column(name = "source")
    private String source;

    /**
     * 图片文件的后缀
     */
    @Column(name = "suffix")
    private String suffix;

    /**
     * 图片的宽
     */
    @Column(name = "width")
    private String width;

    /**
     *  图片的高
     */
    @Column(name = "height")
    private Long height;

    /**
     *  图片存储的根目录
     */
    @Column(name = "root_path")
    private Integer rootPath;

    /**
     *  图片的相对存储路径
     */
    @Column(name = "path")
    private Integer path;

    /**
     *  图片的大小 ，单位： byte
     */
    @Column(name = "size")
    private Integer size;

    /**
     * 图片的MD5值
     */
    @Column(name = "hashcode")
    private String hashcode;

    /**
     * 图片的创建者
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     *  图片的创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 图片的更新者
     */
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     *  图片的更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     *  租户的编码
     */
    @Column(name = "corp_code")
    private String corpCode;

    /**
     *  租户的名称
     */
    @Column(name = "corp_name")
    private String corpName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getSort() {
        return sort;
    }

    public void setSort(Date sort) {
        this.sort = sort;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Integer getRootPath() {
        return rootPath;
    }

    public void setRootPath(Integer rootPath) {
        this.rootPath = rootPath;
    }

    public Integer getPath() {
        return path;
    }

    public void setPath(Integer path) {
        this.path = path;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }
}
