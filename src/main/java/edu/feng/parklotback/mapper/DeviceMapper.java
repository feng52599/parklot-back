package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.Device;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2020-01-19
 */

@Repository
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
    public List<Device> findAll();
}
