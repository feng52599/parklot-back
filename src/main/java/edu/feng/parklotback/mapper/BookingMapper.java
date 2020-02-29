package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.Booking;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2020-02-22
 */

@Repository
@Mapper
public interface BookingMapper extends BaseMapper<Booking> {

    void deleteByPlate(String plate);
}
