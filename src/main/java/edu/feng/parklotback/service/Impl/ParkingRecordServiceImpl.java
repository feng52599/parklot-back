package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.ParkingRecordMapper;
import edu.feng.parklotback.pojo.ParkingRecord;
import edu.feng.parklotback.service.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feng
 * @since 2020-02-05
 */
@Service
@Transactional
public class ParkingRecordServiceImpl extends ServiceImpl<ParkingRecordMapper, ParkingRecord> implements ParkingRecordService {

    @Autowired
    ParkingRecordMapper parkingRecordMapper;
    @Override
    public ParkingRecord findByPlateAndEndTime(String plate) {
        return parkingRecordMapper.findByPlateAndEndTime(plate);
    }

    @Override
    public List<ParkingRecord> findAll() {
        return parkingRecordMapper.findAll();
    }


}
