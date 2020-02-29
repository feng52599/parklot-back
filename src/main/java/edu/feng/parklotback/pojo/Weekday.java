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

@TableName("weekday")
@Data
@Getter
@Setter
public class Weekday implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 平日标准id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平日标准起始时间
     */
    private Time beginTime;

    /**
     * 平日标准结束时间
     */
    private Time endTime;

    /**
     * 收费标准/小时
     */
    private Float charges;


}
