package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.Expenses;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-03-15
 */
public interface ExpensesService extends IService<Expenses> {
    List<Expenses> findAll();

    void delete(Integer id);

    Integer queryTodayOut();
    Integer queryCurrentMonthOut();
    Integer queryCurrentYearOut();
}
