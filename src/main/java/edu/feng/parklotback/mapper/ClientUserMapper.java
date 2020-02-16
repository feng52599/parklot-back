package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.ClientUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: parklot-back
 * @description: 协议客户
 * @author: feng
 * @create: 2020-02-12 20:26
 */

@Repository
@Mapper
public interface ClientUserMapper extends BaseMapper<ClientUser> {
    List<ClientUser> findAll();
}