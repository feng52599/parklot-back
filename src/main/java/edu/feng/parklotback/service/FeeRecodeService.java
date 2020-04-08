package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.FeeRecode;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-02-01
 */
public interface FeeRecodeService extends IService<FeeRecode> {

    List<FeeRecode> findAll();

    List<Map<String, Object>> queryLastSevenDay();
    Integer queryTodayIn();
    Integer queryCurrentMonthIn();
    Integer queryCurrentYearIn();
}
