package cn.js.today.modules.cms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

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
public class Extend implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double extendF2;


    private Date extendD1;


    private Long extendI2;
    private Long extendI3;
    private Double extendF1;
    private String extendS2;
    private Double extendF4;
    private Long extendI4;
    private String extendS4;
    private String extendS1;
    private String extendS3;
    private String extendS8;
    private Date extendD2;
    private String extendS7;
    private String extendS5;
    private Date extendD3;
    private Long extendI1;
    private Date extendD4;
    private Double extendF3;
    private String extendS6;

    public Double getExtendF2() {
        return extendF2;
    }

    public void setExtendF2(Double extendF2) {
        this.extendF2 = extendF2;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public Date getExtendD1() {
        return extendD1;
    }

    public void setExtendD1(Date extendD1) {
        this.extendD1 = extendD1;
    }

    public Long getExtendI2() {
        return extendI2;
    }

    public void setExtendI2(Long extendI2) {
        this.extendI2 = extendI2;
    }

    public Long getExtendI3() {
        return extendI3;
    }

    public void setExtendI3(Long extendI3) {
        this.extendI3 = extendI3;
    }

    public Double getExtendF1() {
        return extendF1;
    }

    public void setExtendF1(Double extendF1) {
        this.extendF1 = extendF1;
    }

    public String getExtendS2() {
        return extendS2;
    }

    public void setExtendS2(String extendS2) {
        this.extendS2 = extendS2;
    }

    public Double getExtendF4() {
        return extendF4;
    }

    public void setExtendF4(Double extendF4) {
        this.extendF4 = extendF4;
    }

    public Long getExtendI4() {
        return extendI4;
    }

    public void setExtendI4(Long extendI4) {
        this.extendI4 = extendI4;
    }

    public String getExtendS4() {
        return extendS4;
    }

    public void setExtendS4(String extendS4) {
        this.extendS4 = extendS4;
    }

    public String getExtendS1() {
        return extendS1;
    }

    public void setExtendS1(String extendS1) {
        this.extendS1 = extendS1;
    }

    public String getExtendS3() {
        return extendS3;
    }

    public void setExtendS3(String extendS3) {
        this.extendS3 = extendS3;
    }

    public String getExtendS8() {
        return extendS8;
    }

    public void setExtendS8(String extendS8) {
        this.extendS8 = extendS8;
    }

    public Date getExtendD2() {
        return extendD2;
    }

    public void setExtendD2(Date extendD2) {
        this.extendD2 = extendD2;
    }

    public String getExtendS7() {
        return extendS7;
    }

    public void setExtendS7(String extendS7) {
        this.extendS7 = extendS7;
    }

    public String getExtendS5() {
        return extendS5;
    }

    public void setExtendS5(String extendS5) {
        this.extendS5 = extendS5;
    }

    public Date getExtendD3() {
        return extendD3;
    }

    public void setExtendD3(Date extendD3) {
        this.extendD3 = extendD3;
    }

    public Long getExtendI1() {
        return extendI1;
    }

    public void setExtendI1(Long extendI1) {
        this.extendI1 = extendI1;
    }

    public Date getExtendD4() {
        return extendD4;
    }

    public void setExtendD4(Date extendD4) {
        this.extendD4 = extendD4;
    }

    public Double getExtendF3() {
        return extendF3;
    }

    public void setExtendF3(Double extendF3) {
        this.extendF3 = extendF3;
    }

    public String getExtendS6() {
        return extendS6;
    }

    public void setExtendS6(String extendS6) {
        this.extendS6 = extendS6;
    }
}
