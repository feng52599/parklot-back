package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.RepairMan;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-04-01
 */
public interface RepairManService extends IService<RepairMan> {
    RepairMan findUserByNameAndPassword(String username, String password);
    RepairMan findUserByNameAndPasswordToSess(String username, String password);
}
