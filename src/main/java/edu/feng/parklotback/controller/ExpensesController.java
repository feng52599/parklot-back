package edu.feng.parklotback.controller;


import edu.feng.parklotback.pojo.Expenses;
import edu.feng.parklotback.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author feng
 * @since 2020-03-15
 */
@RestController
public class ExpensesController {

    @Autowired
    ExpensesService expensesService;

    @CrossOrigin
    @GetMapping("/api/expenses/get")
    public List<Expenses> getAll() throws Exception{
        return expensesService.findAll();
    }

    @CrossOrigin
    @PostMapping("api/expenses/merge")
    public Expenses merge(@RequestBody Expenses expenses) {
        System.out.println("useriddddd" + expenses.getId() + "name" + expenses.getExpensesSummary());
        if ((expenses.getId() == null) || (expenses.getId() == 0)){
            expensesService.save(expenses);
        }else {
            expensesService.updateById(expenses);
        }
        return expenses;
    }

    @CrossOrigin
    @PostMapping("api/expenses/delete")
    public void delete(@RequestBody Expenses expenses) throws Exception{
        expensesService.delete(expenses.getId());
    }
}

