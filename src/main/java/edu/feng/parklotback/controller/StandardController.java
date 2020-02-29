package edu.feng.parklotback.controller;

import edu.feng.parklotback.pojo.ClientStandard;
import edu.feng.parklotback.pojo.Weekday;
import edu.feng.parklotback.pojo.Weekend;
import edu.feng.parklotback.service.ClientStandardService;
import edu.feng.parklotback.service.Impl.WeekendServiceImpl;
import edu.feng.parklotback.service.WeekdayService;
import edu.feng.parklotback.service.WeekendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: parklot-back
 * @description: 所有收费标准
 * @author: feng
 * @create: 2020-02-23 10:18
 */

@RestController
public class StandardController {
    @Autowired
    WeekdayService weekdayService;
    @Autowired
    WeekendService weekendService;
    @Autowired
    ClientStandardService clientStandardService;

    @CrossOrigin
    @GetMapping("api/weekday/getall")
    public List<Weekday> getWeekdayAll() throws Exception{
        return weekdayService.getAll();
    }

    @CrossOrigin
    @GetMapping("api/weekend/getall")
    public List<Weekend> getWeekendAll() throws Exception{
        return weekendService.getAll();
    }

    @CrossOrigin
    @GetMapping("api/standard/getall")
    public List<ClientStandard> getStandardAll() throws Exception{
        return clientStandardService.getAll();
    }

    @CrossOrigin
    @PostMapping("api/clientfee/merge")
    public ClientStandard merge(@RequestBody ClientStandard clientStandard) {
        System.out.println("useriddddd" + clientStandard.getId() + "name" + clientStandard.getClientFee());
        clientStandardService.updateById(clientStandard);
        return clientStandard;
    }

}