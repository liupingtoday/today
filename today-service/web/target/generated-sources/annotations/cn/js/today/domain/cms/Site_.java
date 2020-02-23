package cn.js.today.domain.cms;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Site.class)
public abstract class Site_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<Site, String> copyright;
	public static volatile SingularAttribute<Site, String> siteCode;
	public static volatile SingularAttribute<Site, String> keywords;
	public static volatile SingularAttribute<Site, String> domain;
	public static volatile SingularAttribute<Site, String> siteName;
	public static volatile SingularAttribute<Site, String> logo;
	public static volatile SingularAttribute<Site, String> description;
	public static volatile SingularAttribute<Site, String> theme;
	public static volatile SingularAttribute<Site, Long> id;
	public static volatile SingularAttribute<Site, String> title;

	public static final String COPYRIGHT = "copyright";
	public static final String SITE_CODE = "siteCode";
	public static final String KEYWORDS = "keywords";
	public static final String DOMAIN = "domain";
	public static final String SITE_NAME = "siteName";
	public static final String LOGO = "logo";
	public static final String DESCRIPTION = "description";
	public static final String THEME = "theme";
	public static final String ID = "id";
	public static final String TITLE = "title";

}

