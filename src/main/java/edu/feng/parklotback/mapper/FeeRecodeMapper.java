package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.FeeRecode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
public interface FeeRecodeMapper extends BaseMapper<FeeRecode> {
    List<FeeRecode> findAll();
    List<Map<String, Object>> queryLastSevenDay();
    Integer queryTodayIn();
    Integer queryCurrentMonthIn();
    Integer queryCurrentYearIn();
}
