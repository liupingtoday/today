package cn.js.today.domain.cms;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Content.class)
public abstract class Content_ {

	public static volatile SingularAttribute<Content, String> isRecommend;
	public static volatile SingularAttribute<Content, String> keywords;
	public static volatile SingularAttribute<Content, Integer> coverImageUrl;
	public static volatile SingularAttribute<Content, String> description;
	public static volatile SingularAttribute<Content, String> remark;
	public static volatile SingularAttribute<Content, String> title;
	public static volatile SingularAttribute<Content, String> content;
	public static volatile SingularAttribute<Content, String> deleteFlag;
	public static volatile SingularAttribute<Content, Integer> checkStatus;
	public static volatile SingularAttribute<Content, LocalDateTime> createdTime;
	public static volatile SingularAttribute<Content, String> columnCode;
	public static volatile SingularAttribute<Content, Long> id;
	public static volatile SingularAttribute<Content, String> href;
	public static volatile SingularAttribute<Content, String> tag;
	public static volatile SingularAttribute<Content, LocalDateTime> updatedTime;
	public static volatile SingularAttribute<Content, String> updatedBy;
	public static volatile SingularAttribute<Content, String> author;
	public static volatile SingularAttribute<Content, Integer> isAudit;
	public static volatile SingularAttribute<Content, Integer> sort;
	public static volatile SingularAttribute<Content, String> templatePath;
	public static volatile SingularAttribute<Content, String> isShow;
	public static volatile SingularAttribute<Content, String> createdBy;
	public static volatile SingularAttribute<Content, String> isTop;
	public static volatile SingularAttribute<Content, String> subtitle;
	public static volatile SingularAttribute<Content, String> publisher;
	public static volatile SingularAttribute<Content, Integer> clicks;

	public static final String IS_RECOMMEND = "isRecommend";
	public static final String KEYWORDS = "keywords";
	public static final String COVER_IMAGE_URL = "coverImageUrl";
	public static final String DESCRIPTION = "description";
	public static final String REMARK = "remark";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String DELETE_FLAG = "deleteFlag";
	public static final String CHECK_STATUS = "checkStatus";
	public static final String CREATED_TIME = "createdTime";
	public static final String COLUMN_CODE = "columnCode";
	public static final String ID = "id";
	public static final String HREF = "href";
	public static final String TAG = "tag";
	public static final String UPDATED_TIME = "updatedTime";
	public static final String UPDATED_BY = "updatedBy";
	public static final String AUTHOR = "author";
	public static final String IS_AUDIT = "isAudit";
	public static final String SORT = "sort";
	public static final String TEMPLATE_PATH = "templatePath";
	public static final String IS_SHOW = "isShow";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_TOP = "isTop";
	public static final String SUBTITLE = "subtitle";
	public static final String PUBLISHER = "publisher";
	public static final String CLICKS = "clicks";

}

