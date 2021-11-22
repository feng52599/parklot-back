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
 * @since 2020-04-01
 */
@TableName("repair_man")
@Data
@Getter
@Setter
public class RepairMan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 维修人员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 维修人员姓名
     */
    private String repairName;

    /**
     * 维修人员手机
     */
    private String repairPhone;

    /**
     * 维修人员账号
     */
    private String username;

    /**
     * 维修人员密码
     */
    private String password;


}
