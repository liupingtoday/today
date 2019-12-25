package backup;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, String> image;
	public static volatile SingularAttribute<Category, String> moduleType;
	public static volatile SingularAttribute<Category, String> keywords;
	public static volatile SingularAttribute<Category, String> isCanComment;
	public static volatile SingularAttribute<Category, String> description;
	public static volatile SingularAttribute<Category, String> categoryCode;
	public static volatile SingularAttribute<Category, String> categoryName;
	public static volatile SingularAttribute<Category, String> target;
	public static volatile SingularAttribute<Category, Extend> extend;
	public static volatile SingularAttribute<Category, Long> id;
	public static volatile SingularAttribute<Category, String> href;
	public static volatile SingularAttribute<Category, String> inMenu;
	public static volatile SingularAttribute<Category, String> isNeedAudit;
	public static volatile SingularAttribute<Category, String> inList;
	public static volatile SingularAttribute<Category, String> showModes;

	public static final String IMAGE = "image";
	public static final String MODULE_TYPE = "moduleType";
	public static final String KEYWORDS = "keywords";
	public static final String IS_CAN_COMMENT = "isCanComment";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY_CODE = "categoryCode";
	public static final String CATEGORY_NAME = "categoryName";
	public static final String TARGET = "target";
	public static final String EXTEND = "extend";
	public static final String ID = "id";
	public static final String HREF = "href";
	public static final String IN_MENU = "inMenu";
	public static final String IS_NEED_AUDIT = "isNeedAudit";
	public static final String IN_LIST = "inList";
	public static final String SHOW_MODES = "showModes";

}

