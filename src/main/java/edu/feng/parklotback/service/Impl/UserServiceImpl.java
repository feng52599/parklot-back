package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.UserMapper;
import edu.feng.parklotback.pojo.User;
import edu.feng.parklotback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findUserByNameAndPassword(String username, String password) {
        return userMapper.findUserByNameAndPassword(username, password);
    }

    @Override
    public void delete(int id) throws Exception {
        userMapper.deleteById(id);
    }
}