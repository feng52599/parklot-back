package edu.feng.parklotback.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author feng
 * @since 2020-02-22
 */

@TableName("booking")
@Data
@Getter
@Setter
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 预约时间
     */
    private Date bookingTime;

    /**
     * 预约车牌
     */
    private String plate;

    /**
     * 联系电话
     */
    private String phone;

}
