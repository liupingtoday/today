package cn.js.today.common;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.List;

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
//@MappedSuperclass
public abstract class TreeEntity<T extends TreeEntity<?>> extends DataEntity<T> {

    /**
     * 层次级别
     */
    protected Integer treeLevel;

    /**
     *  全节点名
     */
    protected String treeNames;

    /**
     * 排序号,本级升序
     */
    protected Integer treeSort;

    /**
     * 所有排序号
     */
    protected String treeSorts;

    /**
     *  是否最末级
     */
    protected String treeLeaf;

//    protected String treeName_;

    /**
     * 所有父级编码
     */
    protected String parentCodes;

//    protected Boolean isQueryChildren;

    protected List<T> childList;

    public static final String ROOT_CODE = "0";
    protected T parent;

    public static final int TREE_SORTS_LENGTH = 10;
    public static final int DEFAULT_TREE_SORT = 30;


    public Integer getTreeLevel() {
        return treeLevel;
    }

    public void setTreeLevel(Integer treeLevel) {
        this.treeLevel = treeLevel;
    }

    public String getTreeNames() {
        return treeNames;
    }

    public void setTreeNames(String treeNames) {
        this.treeNames = treeNames;
    }

    public Integer getTreeSort() {
        return treeSort;
    }

    public void setTreeSort(Integer treeSort) {
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

    public String getParentCodes() {
        return parentCodes;
    }

    public void setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
    }

    public static String getRootCode() {
        return ROOT_CODE;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public static int getTreeSortsLength() {
        return TREE_SORTS_LENGTH;
    }

    public static int getDefaultTreeSort() {
        return DEFAULT_TREE_SORT;
    }

    public List<T> getChildList() {
        return childList;
    }

    public void setChildList(List<T> childList) {
        this.childList = childList;
    }
}
