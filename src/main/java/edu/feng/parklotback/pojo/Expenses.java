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
 * @since 2020-03-15
 */

@TableName("expenses")
@Data
@Getter
@Setter
public class Expenses implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支出明细表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 摘要
     */
    private String expensesSummary;

    /**
     * 支出时间
     */
    private Date expensesTime;

    /**
     * 支出金额
     */
    private Float expensesFee;

    /**
     * 备注
     */
    private String remark;


}
