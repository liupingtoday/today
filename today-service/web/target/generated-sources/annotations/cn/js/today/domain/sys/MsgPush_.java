package cn.js.today.domain.sys;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MsgPush.class)
public abstract class MsgPush_ extends cn.js.today.common.DataEntity_ {

	public static volatile SingularAttribute<MsgPush, String> readStatus;
	public static volatile SingularAttribute<MsgPush, String> sendUserCode;
	public static volatile SingularAttribute<MsgPush, String> msgType;
	public static volatile SingularAttribute<MsgPush, String> bizType;
	public static volatile SingularAttribute<MsgPush, String> sendDate;
	public static volatile SingularAttribute<MsgPush, String> pushReturnMsgId;
	public static volatile SingularAttribute<MsgPush, String> pushStatus;
	public static volatile SingularAttribute<MsgPush, String> readDate;
	public static volatile SingularAttribute<MsgPush, String> receiveCode;
	public static volatile SingularAttribute<MsgPush, String> pushReturnCode;
	public static volatile SingularAttribute<MsgPush, String> planPushDate;
	public static volatile SingularAttribute<MsgPush, String> receiveUserName;
	public static volatile SingularAttribute<MsgPush, String> msgContent;
	public static volatile SingularAttribute<MsgPush, String> receiveUserCode;
	public static volatile SingularAttribute<MsgPush, String> msgTitle;
	public static volatile SingularAttribute<MsgPush, String> pushNumber;
	public static volatile SingularAttribute<MsgPush, String> bizKey;
	public static volatile SingularAttribute<MsgPush, String> sendUserName;
	public static volatile SingularAttribute<MsgPush, Long> id;
	public static volatile SingularAttribute<MsgPush, String> pushDate;
	public static volatile SingularAttribute<MsgPush, String> isMergePush;
	public static volatile SingularAttribute<MsgPush, String> pushReturnContent;

	public static final String READ_STATUS = "readStatus";
	public static final String SEND_USER_CODE = "sendUserCode";
	public static final String MSG_TYPE = "msgType";
	public static final String BIZ_TYPE = "bizType";
	public static final String SEND_DATE = "sendDate";
	public static final String PUSH_RETURN_MSG_ID = "pushReturnMsgId";
	public static final String PUSH_STATUS = "pushStatus";
	public static final String READ_DATE = "readDate";
	public static final String RECEIVE_CODE = "receiveCode";
	public static final String PUSH_RETURN_CODE = "pushReturnCode";
	public static final String PLAN_PUSH_DATE = "planPushDate";
	public static final String RECEIVE_USER_NAME = "receiveUserName";
	public static final String MSG_CONTENT = "msgContent";
	public static final String RECEIVE_USER_CODE = "receiveUserCode";
	public static final String MSG_TITLE = "msgTitle";
	public static final String PUSH_NUMBER = "pushNumber";
	public static final String BIZ_KEY = "bizKey";
	public static final String SEND_USER_NAME = "sendUserName";
	public static final String ID = "id";
	public static final String PUSH_DATE = "pushDate";
	public static final String IS_MERGE_PUSH = "isMergePush";
	public static final String PUSH_RETURN_CONTENT = "pushReturnContent";

}

