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
 * @since 2020-03-08
 */

@TableName("repair")
@Data
@Getter
@Setter
public class Repair implements Serializable {


    /**
     * 维修编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备
     */
    private String repairDevice;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 提交人
     */
    private String submitMan;

    /**
     * 维修内容
     */
    private String remark;

    /**
     * 0-待维修 1-正在维修 2-维修完成
     */
    private Integer status;

    /**
     * 维修时间
     */
    private Date repairTime;

    /**
     * 维修人
     */
    private String repairMan;
    /**
     * 维修人员电话
     */
    private String repairPhone;
    /**
     * 维修金额
     */
    private Float repairFee;




}
