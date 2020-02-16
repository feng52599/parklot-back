package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.ClientUserMapper;
import edu.feng.parklotback.mapper.UserMapper;
import edu.feng.parklotback.pojo.ClientUser;
import edu.feng.parklotback.service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: parklot-back
 * @description:
 * @author: feng
 * @create: 2020-02-12 20:33
 */

@Service
public class ClientUserServiceImpl extends ServiceImpl<ClientUserMapper, ClientUser> implements ClientUserService {
    @Autowired
    ClientUserMapper clientUserMapper;

    @Override
    public List<ClientUser> findAll() {

        List<ClientUser> clientUsers = clientUserMapper.findAll();
        System.out.println(clientUsers);
        return clientUsers;
    }

    @Override
    public void delete(int id) throws Exception {
        clientUserMapper.deleteById(id);
    }
}