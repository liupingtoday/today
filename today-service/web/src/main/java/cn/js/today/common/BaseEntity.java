package cn.js.today.common;

import java.io.Serializable;

public abstract class BaseEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String corpCode;

    protected String corpName;


}
