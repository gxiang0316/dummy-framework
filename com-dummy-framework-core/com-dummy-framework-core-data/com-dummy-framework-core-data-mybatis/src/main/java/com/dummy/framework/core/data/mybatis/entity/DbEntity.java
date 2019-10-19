package com.dummy.framework.core.data.mybatis.entity;

import com.dummy.framework.core.data.common.entity.BaseEntity;
import com.dummy.framework.core.data.mybatis.id.DGeneratorTemplate;
import com.dummy.framework.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/03/27
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DbEntity<PK extends Serializable> extends BaseEntity {

    /**
     * 主键 ID
     */
    @KeySql(genId = DGeneratorTemplate.class)
    @ApiModelProperty(value = "主键")
    @Column(updatable = false)
    private PK id;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @Column(updatable = false)
    private Integer createUser;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @ApiModelProperty(value = "创建时间")
    @Column(insertable = false, updatable = false)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    @Column(insertable = false)
    private Integer updateUser;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @ApiModelProperty(value = "更新时间")
    @Column(updatable = false, insertable = false)
    private LocalDateTime updateTime;

}
