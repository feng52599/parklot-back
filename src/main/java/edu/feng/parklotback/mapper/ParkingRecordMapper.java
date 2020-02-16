package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.ParkingRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ParkingRecordMapper extends BaseMapper<ParkingRecord> {

    public ParkingRecord findByPlateAndEndTime(String plate);

    List<ParkingRecord> findAll();
}