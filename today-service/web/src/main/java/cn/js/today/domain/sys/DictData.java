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
@Table(name = "sys_dict_data")
public class DictData extends DataEntity<DictData> {

    /**
     * 字典编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictCodeSequenceGenerator")
    @SequenceGenerator(name = "dictCodeSequenceGenerator")
    private Long dictCode;

    /**
     * 父级编号
     */
    @Column(name = "parent_code")
    private String parentCode  ;

    /**
     * 所有父级编号
     */
    @Column(name = "parent_codes")
    private String parentCodes;

    /**
     * 本级排序号（升序）
     */
    @Column(name = "tree_sort")
    private String treeSort;

    /**
     * 所有级别排序号
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
    @Column(name = "tree_names")
    private String treeNames ;

    /**
     * 字典标签
     */
    @Column(name = "dict_label")
    private String dictLabel;

    /**
     * 字典键值
     */
    @Column(name = "dict_value")
    private String dictValue;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private String dictType;

    /**
     * 系统内置（1是 0否）
     */
    @Column(name = "is_sys")
    private String isSys;

    /**
     * 字典描述
     */
    @Column(name = "description")
    private String description;

    /**
     *  状态（0正常 1删除 2停用）
     */
    @Column(name = "status")
    private String status;

    public Long getDictCode() {
        return dictCode;
    }

    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
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

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
