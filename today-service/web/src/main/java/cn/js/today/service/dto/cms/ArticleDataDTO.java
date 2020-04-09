package cn.js.today.service.dto.cms;

import cn.js.today.common.DataEntity;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-04-07
 * @UpdateUser: liuping
 * @UpdateDate: 2020-04-07
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class ArticleDataDTO extends DataEntity<ArticleDataDTO> {

    private Long id; 	// 栏目编码

    private String content; 		// 文章内容

    private String relation; 		// 相关文章

    private String isCanComment; 	// 是否允许评论

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getIsCanComment() {
        return isCanComment;
    }

    public void setIsCanComment(String isCanComment) {
        this.isCanComment = isCanComment;
    }

    @Override
    public String toString() {
        return "ArticleDataDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", relation='" + relation + '\'' +
                ", isCanComment='" + isCanComment + '\'' +
                '}';
    }
}
