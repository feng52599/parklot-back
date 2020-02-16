package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.Device;
import edu.feng.parklotback.pojo.FeeRecode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-02-15
 */
public interface DeviceService extends IService<Device> {

    List<Device> findAll();

    void delete(Integer id);
}
