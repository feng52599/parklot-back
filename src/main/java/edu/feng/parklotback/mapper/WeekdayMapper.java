package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.Weekday;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2020-02-23
 */

@Repository
@Mapper
public interface WeekdayMapper extends BaseMapper<Weekday> {

    List<Weekday> findAll();
}
