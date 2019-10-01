package com.github.abigail830.jwtdemo.api;

import com.github.abigail830.jwtdemo.application.UserApplService;
import com.github.abigail830.jwtdemo.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserApplService userApplService;

    @GetMapping({"/hello"})
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/users/sign-in")
    public void signIn(@RequestBody ApplicationUser user) {

        userApplService.saveUser(user);
    }

    @GetMapping("/users")
    public ApplicationUser findUser(@PathVariable String userName) {
        return userApplService.findUserByName(userName);
    }
}
