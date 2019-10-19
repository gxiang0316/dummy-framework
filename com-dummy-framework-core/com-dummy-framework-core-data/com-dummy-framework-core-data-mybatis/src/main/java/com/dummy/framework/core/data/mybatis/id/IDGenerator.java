package com.dummy.framework.core.data.mybatis.id;

import tk.mybatis.mapper.genid.GenId;

import java.io.Serializable;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/03/31
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
public interface IDGenerator<T extends Serializable> extends GenId<T> {

}
