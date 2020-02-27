package edu.feng.parklotback.controller;

import edu.feng.parklotback.pojo.ParkingSpace;
import edu.feng.parklotback.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: parklot-back
 * @description:
 * @author: feng
 * @create: 2020-02-15 14:47
 */

@RestController
public class ParkingSpaceController {
    @Autowired
    ParkingSpaceService parkingSpaceService;

    @CrossOrigin
    @GetMapping("/api/space/get")
    @ResponseBody
    public List<ParkingSpace> getAlL() {
        return parkingSpaceService.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/space/getspace")
    @ResponseBody
    public List<ParkingSpace> getSpace() {
        return parkingSpaceService.getSpace();
    }

    @CrossOrigin
    @GetMapping("/api/space/getbookspace")
    @ResponseBody
    public Integer getBookedSpace() {
        return parkingSpaceService.getBookedSpace();
    }
}