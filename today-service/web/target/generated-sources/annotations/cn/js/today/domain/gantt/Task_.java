package cn.js.today.domain.gantt;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Task.class)
public abstract class Task_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<Task, String> resourceId;
	public static volatile SingularAttribute<Task, String> level;
	public static volatile SingularAttribute<Task, String> collapsed;
	public static volatile SingularAttribute<Task, String> start;
	public static volatile SingularAttribute<Task, String> canAdd;
	public static volatile SingularAttribute<Task, String> description;
	public static volatile SingularAttribute<Task, String> canWrite;
	public static volatile SingularAttribute<Task, String> canAddIssue;
	public static volatile SingularAttribute<Task, String> duration;
	public static volatile SingularAttribute<Task, String> endIsMilestone;
	public static volatile SingularAttribute<Task, String> hasChild;
	public static volatile SingularAttribute<Task, String> name;
	public static volatile SingularAttribute<Task, String> progress;
	public static volatile SingularAttribute<Task, String> end;
	public static volatile SingularAttribute<Task, String> canDelete;
	public static volatile SingularAttribute<Task, String> startIsMilestone;
	public static volatile SingularAttribute<Task, Long> taskId;
	public static volatile SingularAttribute<Task, String> status;

	public static final String RESOURCE_ID = "resourceId";
	public static final String LEVEL = "level";
	public static final String COLLAPSED = "collapsed";
	public static final String START = "start";
	public static final String CAN_ADD = "canAdd";
	public static final String DESCRIPTION = "description";
	public static final String CAN_WRITE = "canWrite";
	public static final String CAN_ADD_ISSUE = "canAddIssue";
	public static final String DURATION = "duration";
	public static final String END_IS_MILESTONE = "endIsMilestone";
	public static final String HAS_CHILD = "hasChild";
	public static final String NAME = "name";
	public static final String PROGRESS = "progress";
	public static final String END = "end";
	public static final String CAN_DELETE = "canDelete";
	public static final String START_IS_MILESTONE = "startIsMilestone";
	public static final String TASK_ID = "taskId";
	public static final String STATUS = "status";

}

