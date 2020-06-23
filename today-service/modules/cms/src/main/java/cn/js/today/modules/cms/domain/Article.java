package cn.js.today.modules.cms.domain;

import java.util.Date;
import java.util.Objects;

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
@Table(name = "cms_article")
public class Article {

    private static final long serialVersionUID = 1L;

//    private Category category; 	// 栏目编码

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 	// 栏目编码

    @Column(name = "module_type")
    private String moduleType; 	// 模块类型

    @Column(name = "title")
    private String title; 		// 内容标题

    @Column(name = "href")
    private String href; 		// 外部链接

    @Column(name = "color")
    private String color; 		// 标题颜色

    @Column(name = "image")
    private String image; 		// 内容图片

    @Column(name = "keywords")
    private String keywords; 	// 关键字

    @Column(name = "description")
    private String description; // 描述

    @Column(name = "weight")
    private Integer weight; 	// 权重，越大越靠前

    @Column(name = "weight_date")
    private Date weightDate; 	// 权重期限

    @Column(name = "source")
    private String source; 		// 来源（转载/原创）

    @Column(name = "copyfrom")
    private String copyfrom; 	// 文章来源出处

    @Column(name = "hits")
    private Long hits; 			// 点击数

    @Column(name = "hits_plus")
    private Integer hitsPlus; 			// 支持数

    @Column(name = "hits_minus")
    private Integer hitsMinus; 			// 反对数

    @Column(name = "word_count")
    private Integer wordCount; 			// 字数（不包含html）

//    private ArticleData articleData; 	//文章副表

    @Column(name = "begin_date")
    private Date beginDate; 			// 开始时间

    @Column(name = "end_date")
    private Date endDate; 				// 结束时间

//    private Boolean isQueryArticleData; // 是否查询文章内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getWeightDate() {
        return weightDate;
    }

    public void setWeightDate(Date weightDate) {
        this.weightDate = weightDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(String copyfrom) {
        this.copyfrom = copyfrom;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public Integer getHitsPlus() {
        return hitsPlus;
    }

    public void setHitsPlus(Integer hitsPlus) {
        this.hitsPlus = hitsPlus;
    }

    public Integer getHitsMinus() {
        return hitsMinus;
    }

    public void setHitsMinus(Integer hitsMinus) {
        this.hitsMinus = hitsMinus;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Article(String moduleType, String title, String href, String color, String image, String keywords, String description, Integer weight, Date weightDate, String source, String copyfrom, Long hits, Integer hitsPlus, Integer hitsMinus, Integer wordCount, Date beginDate, Date endDate) {
        this.moduleType = moduleType;
        this.title = title;
        this.href = href;
        this.color = color;
        this.image = image;
        this.keywords = keywords;
        this.description = description;
        this.weight = weight;
        this.weightDate = weightDate;
        this.source = source;
        this.copyfrom = copyfrom;
        this.hits = hits;
        this.hitsPlus = hitsPlus;
        this.hitsMinus = hitsMinus;
        this.wordCount = wordCount;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Article() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) &&
                Objects.equals(moduleType, article.moduleType) &&
                Objects.equals(title, article.title) &&
                Objects.equals(href, article.href) &&
                Objects.equals(color, article.color) &&
                Objects.equals(image, article.image) &&
                Objects.equals(keywords, article.keywords) &&
                Objects.equals(description, article.description) &&
                Objects.equals(weight, article.weight) &&
                Objects.equals(weightDate, article.weightDate) &&
                Objects.equals(source, article.source) &&
                Objects.equals(copyfrom, article.copyfrom) &&
                Objects.equals(hits, article.hits) &&
                Objects.equals(hitsPlus, article.hitsPlus) &&
                Objects.equals(hitsMinus, article.hitsMinus) &&
                Objects.equals(wordCount, article.wordCount) &&
                Objects.equals(beginDate, article.beginDate) &&
                Objects.equals(endDate, article.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleType, title, href, color, image, keywords, description, weight, weightDate, source, copyfrom, hits, hitsPlus, hitsMinus, wordCount, beginDate, endDate);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", moduleType='" + moduleType + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", color='" + color + '\'' +
                ", image='" + image + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", weightDate=" + weightDate +
                ", source='" + source + '\'' +
                ", copyfrom='" + copyfrom + '\'' +
                ", hits=" + hits +
                ", hitsPlus=" + hitsPlus +
                ", hitsMinus=" + hitsMinus +
                ", wordCount=" + wordCount +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
