package com.myproject.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private List<String> users = new ArrayList<>();
    
    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }
    
    @PostMapping
    public String addUser(@RequestBody String userName) {
        users.add(userName);
        return "User added: " + userName;
    }
    
    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        if (id >= 0 && id < users.size()) {
            return users.get(id);
        }
        return "User not found";
    }
}
