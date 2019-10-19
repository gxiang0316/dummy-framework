package com.dummy.framework.core.data.mybatis.mapper;

import com.dummy.framework.core.data.mybatis.entity.DbEntity;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/03/31
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
public interface DbMapper<T extends DbEntity<PK>, PK extends Serializable> extends Mapper<T> {

}
