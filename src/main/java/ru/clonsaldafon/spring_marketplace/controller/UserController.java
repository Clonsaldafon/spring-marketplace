package ru.clonsaldafon.spring_marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clonsaldafon.spring_marketplace.model.User;
import ru.clonsaldafon.spring_marketplace.model.UserBase;
import ru.clonsaldafon.spring_marketplace.model.Vendor;
import ru.clonsaldafon.spring_marketplace.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserBase>> getAllUsers() {
        List<UserBase> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/vendor")
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = service.createVendor(vendor);
        return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
    }
}
