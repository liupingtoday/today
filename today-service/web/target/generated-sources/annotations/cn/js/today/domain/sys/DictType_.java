package cn.js.today.domain.sys;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DictType.class)
public abstract class DictType_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<DictType, String> dictName;
	public static volatile SingularAttribute<DictType, Long> id;
	public static volatile SingularAttribute<DictType, String> dictType;
	public static volatile SingularAttribute<DictType, String> isSys;
	public static volatile SingularAttribute<DictType, String> status;

	public static final String DICT_NAME = "dictName";
	public static final String ID = "id";
	public static final String DICT_TYPE = "dictType";
	public static final String IS_SYS = "isSys";
	public static final String STATUS = "status";

}

