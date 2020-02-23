package cn.js.today.domain.sys;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Config.class)
public abstract class Config_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<Config, String> configName;
	public static volatile SingularAttribute<Config, String> configKey;
	public static volatile SingularAttribute<Config, Long> id;
	public static volatile SingularAttribute<Config, String> configValue;
	public static volatile SingularAttribute<Config, String> isSys;

	public static final String CONFIG_NAME = "configName";
	public static final String CONFIG_KEY = "configKey";
	public static final String ID = "id";
	public static final String CONFIG_VALUE = "configValue";
	public static final String IS_SYS = "isSys";

}

