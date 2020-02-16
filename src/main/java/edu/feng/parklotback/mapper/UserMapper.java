package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: parklot-back
 * @description: User
 * @author: feng
 * @create: 2020-02-12 14:42
 */

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();
    User findUserByNameAndPassword(String username, String password);
}