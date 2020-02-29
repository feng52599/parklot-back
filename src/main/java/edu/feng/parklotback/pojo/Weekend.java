package edu.feng.parklotback.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import java.sql.Time;

/**
 * <p>
 * 
 * </p>
 *
 * @author feng
 * @since 2020-02-23
 */

@TableName("weekend")
@Data
@Getter
@Setter
public class Weekend implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 周末收费标准id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 周末收费起始时间
     */
    private Time beginTime;

    /**
     * 结束时间
     */
    private Time endTime;

    /**
     * 周末收费标准
     */
    private Float charges;

}
