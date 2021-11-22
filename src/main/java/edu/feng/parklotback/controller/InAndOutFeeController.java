package edu.feng.parklotback.controller;

import edu.feng.parklotback.service.ExpensesService;
import edu.feng.parklotback.service.FeeRecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: parklot-back
 * @description: 收支汇总
 * @author: feng
 * @create: 2020-03-15 15:18
 */
@RestController
public class InAndOutFeeController {
    /*
    收入
     */
    @Autowired
    FeeRecodeService feeRecodeService;

    /*
    支出
     */

    @Autowired
    ExpensesService expensesService;


    @GetMapping("/api/inandout/todayin")
    @CrossOrigin
    public Integer getTodayIn(){
        return feeRecodeService.queryTodayIn();
    }

    @GetMapping("/api/inandout/todayout")
    @CrossOrigin
    public Integer getTodayOut(){
        return expensesService.queryTodayOut();
    }

    @GetMapping("/api/inandout/monthin")
    @CrossOrigin
    public Integer getCurrentMonthIn(){
        return feeRecodeService.queryCurrentMonthIn();
    }

    @GetMapping("/api/inandout/monthout")
    @CrossOrigin
    public Integer getCurrentMonthOut(){
        return expensesService.queryCurrentMonthOut();
    }

    @GetMapping("/api/inandout/yearin")
    @CrossOrigin
    public Integer getCurrentYearIn(){
        return feeRecodeService.queryCurrentYearIn();
    }

    @GetMapping("/api/inandout/yearout")
    @CrossOrigin
    public Integer getCurrentYearOut(){
        return expensesService.queryCurrentYearOut();
    }
}