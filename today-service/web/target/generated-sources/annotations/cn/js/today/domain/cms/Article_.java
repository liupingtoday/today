package cn.js.today.domain.cms;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Article.class)
public abstract class Article_ {

	public static volatile SingularAttribute<Article, String> image;
	public static volatile SingularAttribute<Article, String> moduleType;
	public static volatile SingularAttribute<Article, String> color;
	public static volatile SingularAttribute<Article, String> keywords;
	public static volatile SingularAttribute<Article, Integer> wordCount;
	public static volatile SingularAttribute<Article, Date> endDate;
	public static volatile SingularAttribute<Article, String> description;
	public static volatile SingularAttribute<Article, Integer> weight;
	public static volatile SingularAttribute<Article, String> source;
	public static volatile SingularAttribute<Article, String> title;
	public static volatile SingularAttribute<Article, Integer> hitsPlus;
	public static volatile SingularAttribute<Article, Long> hits;
	public static volatile SingularAttribute<Article, Date> beginDate;
	public static volatile SingularAttribute<Article, Integer> hitsMinus;
	public static volatile SingularAttribute<Article, Long> id;
	public static volatile SingularAttribute<Article, String> href;
	public static volatile SingularAttribute<Article, Date> weightDate;
	public static volatile SingularAttribute<Article, String> copyfrom;

	public static final String IMAGE = "image";
	public static final String MODULE_TYPE = "moduleType";
	public static final String COLOR = "color";
	public static final String KEYWORDS = "keywords";
	public static final String WORD_COUNT = "wordCount";
	public static final String END_DATE = "endDate";
	public static final String DESCRIPTION = "description";
	public static final String WEIGHT = "weight";
	public static final String SOURCE = "source";
	public static final String TITLE = "title";
	public static final String HITS_PLUS = "hitsPlus";
	public static final String HITS = "hits";
	public static final String BEGIN_DATE = "beginDate";
	public static final String HITS_MINUS = "hitsMinus";
	public static final String ID = "id";
	public static final String HREF = "href";
	public static final String WEIGHT_DATE = "weightDate";
	public static final String COPYFROM = "copyfrom";

}

