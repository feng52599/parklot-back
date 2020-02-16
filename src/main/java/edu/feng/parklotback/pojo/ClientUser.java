package edu.feng.parklotback.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import java.sql.Date;

/**
 * @program: parklot-back
 * @description: 协议客户
 * @author: feng
 * @create: 2020-02-12 20:23
 */


@TableName("client_user")
@Data
@Getter
@Setter
public class ClientUser implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String clientName;
    private String clientPlate;
    private String phone;
    private Date clientBegin;
    private Date clientEnd;
}