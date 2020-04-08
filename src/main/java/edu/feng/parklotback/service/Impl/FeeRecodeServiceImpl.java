package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.FeeRecodeMapper;
import edu.feng.parklotback.pojo.FeeRecode;
import edu.feng.parklotback.service.FeeRecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FeeRecodeServiceImpl extends ServiceImpl<FeeRecodeMapper, FeeRecode> implements FeeRecodeService {
    @Autowired
    FeeRecodeMapper feeRecodeMapper;
    @Override
    public List<FeeRecode> findAll() {
        List<FeeRecode>feeRecodes = feeRecodeMapper.findAll();
//        for (FeeRecode feeRecode: feeRecodes){
//            java.sql.Date beginTime = new java.sql.Date(new java.util.Date().getTime());
//            System.out.println(beginTime);
//            feeRecode.setPayTime(beginTime);
//        }
        return feeRecodes;
    }

    @Override
    public List<Map<String, Object>> queryLastSevenDay() {
        return feeRecodeMapper.queryLastSevenDay();
    }

    @Override
    public Integer queryTodayIn() {
        return feeRecodeMapper.queryTodayIn();
    }

    @Override
    public Integer queryCurrentMonthIn() {
        return feeRecodeMapper.queryCurrentMonthIn();
    }

    @Override
    public Integer queryCurrentYearIn() {
        return feeRecodeMapper.queryCurrentYearIn();
    }


}