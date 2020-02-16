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
 * @since 2020-02-15
 */

@TableName("fee_recode")
@Data
@Getter
@Setter
public class FeeRecode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车牌
     */
    private String plate;

    /**
     * 停车金额
     */
    private Float parkingFee;

    /**
     * 付款时间
     */
    private Date payTime;

}
