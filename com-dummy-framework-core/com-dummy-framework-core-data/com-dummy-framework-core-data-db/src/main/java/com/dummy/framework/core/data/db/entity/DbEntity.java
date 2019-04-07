package com.dummy.framework.core.data.db.entity;

import com.dummy.framework.core.data.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Vincent Kang
 * @date 19-3-27
 **/
@Data
public class DbEntity<PK extends Serializable> extends BaseEntity {

    @Id
    private PK id;

}
