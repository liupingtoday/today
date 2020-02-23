package cn.js.today.domain.sys;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Module.class)
public abstract class Module_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<Module, Long> moduleCode;
	public static volatile SingularAttribute<Module, String> upgradeInfo;
	public static volatile SingularAttribute<Module, String> moduleName;
	public static volatile SingularAttribute<Module, String> description;
	public static volatile SingularAttribute<Module, String> mainClassName;
	public static volatile SingularAttribute<Module, String> currentVersion;
	public static volatile SingularAttribute<Module, String> status;

	public static final String MODULE_CODE = "moduleCode";
	public static final String UPGRADE_INFO = "upgradeInfo";
	public static final String MODULE_NAME = "moduleName";
	public static final String DESCRIPTION = "description";
	public static final String MAIN_CLASS_NAME = "mainClassName";
	public static final String CURRENT_VERSION = "currentVersion";
	public static final String STATUS = "status";

}

