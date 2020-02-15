package cn.js.today.domain.cms;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2019-12-14
 * @UpdateUser: liuping
 * @UpdateDate: 2019-12-14
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "article_data")
public class ArticleData {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 	// 栏目编码

    @Column(name = "content")
    private String content; 		// 文章内容

    @Column(name = "relation")
    private String relation; 		// 相关文章

    @Column(name = "is_can_comment")
    private String isCanComment; 	// 是否允许评论

//    private Extend extend; 			// 扩展字段

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

}
