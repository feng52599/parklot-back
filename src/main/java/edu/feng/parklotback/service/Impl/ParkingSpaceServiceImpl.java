package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.ParkingSpaceMapper;
import edu.feng.parklotback.pojo.ParkingSpace;
import edu.feng.parklotback.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author feng
 * @since 2020-02-15
 */
@Service
@Transactional
public class ParkingSpaceServiceImpl extends ServiceImpl<ParkingSpaceMapper, ParkingSpace> implements ParkingSpaceService {

    @Autowired
    ParkingSpaceMapper parkingSpaceMapper;

    @Override
    public void carEnter() {
        ParkingSpace parkingSpace = parkingSpaceMapper.selectById(1);
        parkingSpace.setParkingSpace(parkingSpace.getParkingSpace() + 1);
        parkingSpace.setRemainingSpace(parkingSpace.getRemainingSpace() - 1);
        parkingSpaceMapper.updateById(parkingSpace);
    }

    @Override
    public void carOut() {
        ParkingSpace parkingSpace = parkingSpaceMapper.selectById(1);
        parkingSpace.setParkingSpace(parkingSpace.getParkingSpace() - 1);
        parkingSpace.setRemainingSpace(parkingSpace.getRemainingSpace() + 1);
        parkingSpaceMapper.updateById(parkingSpace);
    }

    @Override
    public List<ParkingSpace> findAll() {
        return parkingSpaceMapper.findAll();
    }

    @Override
    public List<ParkingSpace> getSpace() {
        return parkingSpaceMapper.getSpace();
    }
}
