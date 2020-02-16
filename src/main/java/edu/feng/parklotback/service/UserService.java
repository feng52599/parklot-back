package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> findAll();
    User findUserByNameAndPassword(String username, String password);
    void delete(int id) throws Exception;
}
