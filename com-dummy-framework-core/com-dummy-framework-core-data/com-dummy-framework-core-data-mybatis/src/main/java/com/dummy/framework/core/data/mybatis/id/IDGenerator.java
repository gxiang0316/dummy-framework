package com.dummy.framework.core.data.mybatis.id;

import tk.mybatis.mapper.genid.GenId;

import java.io.Serializable;

public interface IDGenerator<T extends Serializable> extends GenId<T> {

}
