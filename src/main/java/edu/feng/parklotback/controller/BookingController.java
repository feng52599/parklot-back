package edu.feng.parklotback.controller;


import edu.feng.parklotback.pojo.Booking;
import edu.feng.parklotback.pojo.ClientUser;
import edu.feng.parklotback.service.BookingService;
import edu.feng.parklotback.service.ParkingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author feng
 * @since 2020-02-22
 */

@RestController

public class BookingController {
    @Autowired
    BookingService bookingService;

    @Autowired
    ParkingUserService parkingUserService;

    @CrossOrigin
    @PostMapping("/api/booking/merge")
    public Booking merge(@RequestBody Booking booking) {
        System.out.println("useriddddd" + booking.getId() + "name" + booking.getBookingTime() + "plate"+ booking.getPlate()+"phone" + booking.getPhone());
        if ((booking.getId() == null) || (booking.getId() == 0)){
            bookingService.save(booking);
            // 新增时更新预约状态
            parkingUserService.editByPlate(booking.getPlate());
        }else {
            bookingService.updateById(booking);
        }
        return booking;
    }

    @CrossOrigin
    @PostMapping("/api/booking/delete")
    public void delete(@RequestBody Booking booking) {
        bookingService.delete(booking.getId());

    }

}

