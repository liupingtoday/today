package cn.js.today.domain.sys;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DictData.class)
public abstract class DictData_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<DictData, String> dictValue;
	public static volatile SingularAttribute<DictData, String> treeSort;
	public static volatile SingularAttribute<DictData, String> treeLeaf;
	public static volatile SingularAttribute<DictData, String> parentCodes;
	public static volatile SingularAttribute<DictData, String> description;
	public static volatile SingularAttribute<DictData, String> treeSorts;
	public static volatile SingularAttribute<DictData, String> dictType;
	public static volatile SingularAttribute<DictData, String> dictLabel;
	public static volatile SingularAttribute<DictData, String> treeLevel;
	public static volatile SingularAttribute<DictData, Long> dictCode;
	public static volatile SingularAttribute<DictData, String> parentCode;
	public static volatile SingularAttribute<DictData, String> treeNames;
	public static volatile SingularAttribute<DictData, String> isSys;
	public static volatile SingularAttribute<DictData, String> status;

	public static final String DICT_VALUE = "dictValue";
	public static final String TREE_SORT = "treeSort";
	public static final String TREE_LEAF = "treeLeaf";
	public static final String PARENT_CODES = "parentCodes";
	public static final String DESCRIPTION = "description";
	public static final String TREE_SORTS = "treeSorts";
	public static final String DICT_TYPE = "dictType";
	public static final String DICT_LABEL = "dictLabel";
	public static final String TREE_LEVEL = "treeLevel";
	public static final String DICT_CODE = "dictCode";
	public static final String PARENT_CODE = "parentCode";
	public static final String TREE_NAMES = "treeNames";
	public static final String IS_SYS = "isSys";
	public static final String STATUS = "status";

}

