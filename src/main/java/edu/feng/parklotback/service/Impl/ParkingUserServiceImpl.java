package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.ParkingUserMapper;
import edu.feng.parklotback.pojo.ParkingUser;
import edu.feng.parklotback.service.ParkingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feng
 * @since 2020-02-21
 */
@Service
@Transactional
public class ParkingUserServiceImpl extends ServiceImpl<ParkingUserMapper, ParkingUser> implements ParkingUserService {
    @Autowired
    private ParkingUserMapper parkingUserMapper;

    @Override
    public ParkingUser findUserByNameAndPassword(String username, String password) {
        return parkingUserMapper.findUserByNameAndPassword(username, password);
    }

    @Override
    public ParkingUser findUserByNameAndPasswordToSess(String username, String password) {
        return parkingUserMapper.findUserByNameAndPasswordToSess(username, password);
    }

    @Override
    public void editByPlate(String plate) {
        parkingUserMapper.editByPlate(plate);
    }
}
