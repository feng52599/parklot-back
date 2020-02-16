package edu.feng.parklotback.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author feng
 * @since 2020-02-15
 */
@TableName("parking_space")
@Data
@Getter
@Setter
public class ParkingSpace implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 已停车位
     */
    private Integer parkingSpace;

    /**
     * 剩余车位
     */
    private Integer remainingSpace;

    /**
     * 总车位
     */
    private Integer allSpace;


}
