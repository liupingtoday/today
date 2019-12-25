package cn.js.today.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArticleData.class)
public abstract class ArticleData_ {

	public static volatile SingularAttribute<ArticleData, String> isCanComment;
	public static volatile SingularAttribute<ArticleData, Long> id;
	public static volatile SingularAttribute<ArticleData, String> content;
	public static volatile SingularAttribute<ArticleData, String> relation;

	public static final String IS_CAN_COMMENT = "isCanComment";
	public static final String ID = "id";
	public static final String CONTENT = "content";
	public static final String RELATION = "relation";

}

