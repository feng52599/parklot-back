package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.ParkingRecord;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-02-14
 */
public interface ParkingRecordService extends IService<ParkingRecord> {
    public ParkingRecord findByPlateAndEndTime(String plate);

    List<ParkingRecord> findAll();
}
