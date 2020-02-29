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
 * @since 2020-02-23
 */

@TableName("client_standard")
@Data
@Getter
@Setter
public class ClientStandard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 协议类型
     */
    private String clientType;

    /**
     * 收费标准
     */
    private Integer clientFee;


}
