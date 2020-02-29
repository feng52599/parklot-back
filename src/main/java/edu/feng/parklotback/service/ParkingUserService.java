package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.ParkingUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-02-21
 */
public interface ParkingUserService extends IService<ParkingUser> {
    ParkingUser findUserByNameAndPassword(String username, String password);
    ParkingUser findUserByNameAndPasswordToSess(String username, String password);

    void editByPlate(String plate);
}
