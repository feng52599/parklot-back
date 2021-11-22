package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.feng.parklotback.pojo.Expenses;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2020-03-15
 */
@Mapper
@Repository
public interface ExpensesMapper extends BaseMapper<Expenses> {
    public List<Expenses> findAll();
    Integer queryTodayOut();
    Integer queryCurrentMonthOut();
    Integer queryCurrentYearOut();

}
