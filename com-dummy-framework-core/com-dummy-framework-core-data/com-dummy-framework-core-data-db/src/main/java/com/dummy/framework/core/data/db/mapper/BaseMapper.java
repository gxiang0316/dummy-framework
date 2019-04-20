package com.dummy.framework.core.data.db.mapper;

import com.dummy.framework.core.data.db.entity.DbEntity;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Vincent Kang
 * @date 19-3-31
 **/
public interface BaseMapper<T extends DbEntity> extends Mapper<T> {

}
