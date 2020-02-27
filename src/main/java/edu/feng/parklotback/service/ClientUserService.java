package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.ClientUser;

import java.util.List;

/**
 * @program: parklot-back
 * @description:
 * @author: feng
 * @create: 2020-02-01 20:31
 */
public interface ClientUserService extends IService<ClientUser> {
    List<ClientUser> findAll();
    void delete(int id) throws Exception;
}