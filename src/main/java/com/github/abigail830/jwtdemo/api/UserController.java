package com.github.abigail830.jwtdemo.api;

import com.github.abigail830.jwtdemo.application.UserApplService;
import com.github.abigail830.jwtdemo.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserApplService userApplService;

    @PostMapping("/register")
    public void register(@RequestBody ApplicationUser user) {
        userApplService.register(user);
    }

//    @PostMapping("/login")
//    public void login(@RequestBody ApplicationUser user) {
//        userApplService.saveUserLoginInfo(user);
//    }

    @GetMapping
    public ApplicationUser findUser(@RequestParam String userName) {
        return userApplService.findUserByName(userName);
    }
}
