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
@Table(name = "sys_dict_type")
public class DictType extends DataEntity<DictType> {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictTypeSequenceGenerator")
    @SequenceGenerator(name = "dictTypeSequenceGenerator")
    private Long id;

    /**
     * 字典名称
     */
    @Column(name = "dict_name")
    private String dictName;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private String dictType;

    /**
     * 是否系统字典
     */
    @Column(name = "is_sys")
    private String isSys;

    /**
     *  状态（0正常 1删除 2停用）
     */
    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
