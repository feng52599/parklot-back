package edu.feng.parklotback.controller;

import edu.feng.parklotback.pojo.ClientUser;
import edu.feng.parklotback.pojo.FeeRecode;
import edu.feng.parklotback.service.FeeRecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: parklot-back
 * @description:
 * @author: feng
 * @create: 2020-02-15 10:03
 */


@RestController
public class FeeRecordController {
    @Autowired
    FeeRecodeService feeRecodeService;

    @CrossOrigin
    @GetMapping("/api/fee/get")
    public List<FeeRecode> getAll() throws Exception{
        return feeRecodeService.findAll();
    }



    @CrossOrigin
    @GetMapping("/api/fee/getseven")
    public List<Map<String, Object>> getSeven() throws Exception{
        return feeRecodeService.queryLastSevenDay();
    }
}