package com.dummy.framework.core.data.mybatis.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Vincent Kang
 * @date 19-3-31
 **/
@Data
@Entity
@Table(name = "T_USER")
@EqualsAndHashCode(callSuper = true)
public class TestEntity extends DbEntity<Long> {

    private String username;

    private String password;

}

