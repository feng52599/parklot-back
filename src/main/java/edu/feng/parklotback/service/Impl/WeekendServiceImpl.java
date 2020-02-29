package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.WeekdayMapper;
import edu.feng.parklotback.mapper.WeekendMapper;
import edu.feng.parklotback.pojo.Weekend;
import edu.feng.parklotback.service.WeekendService;
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
 * @since 2020-02-23
 */
@Service
@Transactional
public class WeekendServiceImpl extends ServiceImpl<WeekendMapper, Weekend> implements WeekendService {

    @Autowired
    WeekendMapper weekendMapper;
    @Override
    public List<Weekend> getAll() {
        return weekendMapper.findAll();
    }
}
