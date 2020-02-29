package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.Booking;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-02-22
 */
public interface BookingService extends IService<Booking> {

    void deleteByPlate(String plate);

    void delete(int id);
}
