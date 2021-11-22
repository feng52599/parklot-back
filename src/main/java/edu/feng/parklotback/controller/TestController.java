package edu.feng.parklotback.controller;

import edu.feng.parklotback.pojo.User;
import edu.feng.parklotback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: parklot-back
 * @description: TODO
 * @author: feng
 * @create: 2021-11-22 20:53
 * @version: 1.0
 */
@RestController()
public class TestController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> TestGit() {
        return userService.findAll();
    }
}