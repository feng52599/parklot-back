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
 * @since 2020-01-15
 */

@TableName("device")
@Data
@Getter
@Setter
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String deviceName;

    /**
     * 数量
     */
    private Integer deviceNum;

    /**
     * 是否正常使用 0 false 1 true
     */
    private Boolean isUsed;


    /**
     * 备注
     */
    private String remark;

}
