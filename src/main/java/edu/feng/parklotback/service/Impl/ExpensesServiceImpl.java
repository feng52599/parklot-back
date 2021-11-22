package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.feng.parklotback.mapper.ExpensesMapper;
import edu.feng.parklotback.pojo.Expenses;
import edu.feng.parklotback.service.ExpensesService;
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
 * @since 2020-03-15
 */
@Service
@Transactional
public class ExpensesServiceImpl extends ServiceImpl<ExpensesMapper, Expenses> implements ExpensesService {

    @Autowired
    ExpensesMapper expensesMapper;

    @Override
    public List<Expenses> findAll() {
        return expensesMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        expensesMapper.deleteById(id);
    }

    @Override
    public Integer queryTodayOut() {
        return expensesMapper.queryTodayOut();
    }

    @Override
    public Integer queryCurrentMonthOut() {
        return expensesMapper.queryCurrentMonthOut();
    }

    @Override
    public Integer queryCurrentYearOut() {
        return expensesMapper.queryCurrentYearOut();
    }
}
