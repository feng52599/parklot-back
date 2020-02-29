package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.BookingMapper;
import edu.feng.parklotback.pojo.Booking;
import edu.feng.parklotback.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feng
 * @since 2020-02-22
 */
@Service
@Transactional
public class BookingServiceImpl extends ServiceImpl<BookingMapper, Booking> implements BookingService {
    @Autowired
    BookingMapper bookingMapper;

    @Override
    public void deleteByPlate(String plate) {
        bookingMapper.deleteByPlate(plate);
    }

    @Override
    public void delete(int id) {
        bookingMapper.deleteById(id);
    }
}
