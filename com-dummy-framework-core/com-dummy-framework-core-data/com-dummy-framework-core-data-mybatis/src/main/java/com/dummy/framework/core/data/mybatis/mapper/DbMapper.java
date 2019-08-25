package com.dummy.framework.core.data.mybatis.mapper;

import com.dummy.framework.core.data.mybatis.entity.DbEntity;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;

/**
 * @author Vincent Kang
 * @date 19-3-31
 **/
public interface DbMapper<T extends DbEntity<PK>, PK extends Serializable> extends Mapper<T> {

}
