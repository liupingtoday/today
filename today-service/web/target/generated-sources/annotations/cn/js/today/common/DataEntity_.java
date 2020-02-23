package cn.js.today.common;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DataEntity.class)
public abstract class DataEntity_ {

	public static volatile SingularAttribute<DataEntity, LocalDateTime> updatedTime;
	public static volatile SingularAttribute<DataEntity, String> updatedBy;
	public static volatile SingularAttribute<DataEntity, String> createdBy;
	public static volatile SingularAttribute<DataEntity, LocalDateTime> createdTime;
	public static volatile SingularAttribute<DataEntity, String> remarks;

	public static final String UPDATED_TIME = "updatedTime";
	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String REMARKS = "remarks";

}

