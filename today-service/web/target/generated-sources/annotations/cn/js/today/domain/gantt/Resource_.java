package cn.js.today.domain.gantt;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Resource.class)
public abstract class Resource_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<Resource, Long> resourceId;
	public static volatile SingularAttribute<Resource, String> roleId;
	public static volatile SingularAttribute<Resource, String> name;

	public static final String RESOURCE_ID = "resourceId";
	public static final String ROLE_ID = "roleId";
	public static final String NAME = "name";

}

