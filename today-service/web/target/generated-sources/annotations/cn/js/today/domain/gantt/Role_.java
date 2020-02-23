package cn.js.today.domain.gantt;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<Role, Long> roleId;
	public static volatile SingularAttribute<Role, String> name;

	public static final String ROLE_ID = "roleId";
	public static final String NAME = "name";

}

