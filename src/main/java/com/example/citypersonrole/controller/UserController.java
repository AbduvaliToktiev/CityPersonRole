package com.example.citypersonrole.controller;

import com.example.citypersonrole.entity.Users;
import com.example.citypersonrole.service.RoleService;
import com.example.citypersonrole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/registration")
    public String registration(@RequestBody Users users) {
        users.setDate(new Date());
        users.setActive(true);
        users.setRoles(this.roleService.roleList("ADMIN"));
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        this.userService.save(users);
        return "SUCCESS";
    }

    @GetMapping(value = "/get-all-user")
    public List<Users> usersList() {
        return this.userService.usersList();
    }

    @DeleteMapping(value = "/delete-user")
    public String delete(@RequestParam(name = "id") Long id) {
        try {
            this.userService.delete(id);
        } catch (Exception e) {
            e.getMessage();
            return "ID NOT FOUND";
        }
        return "SUCCESS";
    }

}
