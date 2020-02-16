package edu.feng.parklotback.controller;

import edu.feng.parklotback.mapper.DeviceMapper;
import edu.feng.parklotback.pojo.Device;
import edu.feng.parklotback.pojo.FeeRecode;
import edu.feng.parklotback.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: parklot-back
 * @description:
 * @author: feng
 * @create: 2020-02-15 11:44
 */

@RestController
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @CrossOrigin
    @GetMapping("/api/device/get")
    public List<Device> getAll() throws Exception{
        return deviceService.findAll();
    }

    @CrossOrigin
    @PostMapping("api/device/merge")
    public Device merge(@RequestBody Device device) {
        System.out.println("useriddddd" + device.getId() + "name" + device.getDeviceName());
        if ((device.getId() == null) || (device.getId() == 0)){
            deviceService.save(device);
        }else {
            deviceService.updateById(device);
        }
        return device;
    }

    @CrossOrigin
    @PostMapping("api/device/delete")
    public void delete(@RequestBody Device device) throws Exception{
        deviceService.delete(device.getId());
    }
}