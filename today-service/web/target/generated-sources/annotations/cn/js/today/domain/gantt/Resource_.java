package cn.js.today.domain.gantt;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Assignee.class)
public abstract class Resource_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<Assignee, Long> resourceId;
	public static volatile SingularAttribute<Assignee, String> roleId;
	public static volatile SingularAttribute<Assignee, String> name;
	public static volatile SingularAttribute<Assignee, Long> taskId;

	public static final String RESOURCE_ID = "resourceId";
	public static final String ROLE_ID = "roleId";
	public static final String NAME = "name";
	public static final String TASK_ID = "taskId";

}

