package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.DeviceMapper;
import edu.feng.parklotback.pojo.Device;
import edu.feng.parklotback.pojo.FeeRecode;
import edu.feng.parklotback.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feng
 * @since 2020-02-15
 */
@Service
@Transactional
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public List<Device> findAll() {
        return deviceMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        deviceMapper.deleteById(id);
    }
}
