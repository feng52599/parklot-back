package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.ParkingSpace;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-02-15
 */
public interface ParkingSpaceService extends IService<ParkingSpace> {
    public void carEnter();
    public void carOut();
    List<ParkingSpace> findAll();

    List<ParkingSpace> getSpace();
}
