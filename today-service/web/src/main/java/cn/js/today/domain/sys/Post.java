package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 员工岗位表
 * @Author: liuping
 * @Since 2020-03-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_post")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Post extends DataEntity<Post> {

    /**
     * 岗位编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "post_code")
    private Long postCode;

    /**
     * 岗位名称
     */
    @Column(name = "post_name")
    private String postName;

    /**
     * 岗位分类（高管、中层、基层）
     */
    @Column(name = "post_type")
    private String postType;

    /**
     * 岗位排序（升序）
     */
    @Column(name = "post_sort")
    private String postSort;

    /**
     * 状态（0正常 1删除 2停用）
     */
    @Column(name = "status")
    private String status;

    public Long getPostCode() {
        return postCode;
    }

    public void setPostCode(Long postCode) {
        this.postCode = postCode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostSort() {
        return postSort;
    }

    public void setPostSort(String postSort) {
        this.postSort = postSort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
