package ru.clonsaldafon.spring_marketplace.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.clonsaldafon.spring_marketplace.model.User;
import ru.clonsaldafon.spring_marketplace.model.UserBase;
import ru.clonsaldafon.spring_marketplace.model.Vendor;
import ru.clonsaldafon.spring_marketplace.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Validated
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserBase> getAll() {
        return service.getAll();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@Valid @RequestBody User user) {
        service.createUser(user);
        return "redirect:/login?registered";
    }

    @PostMapping("/vendors")
    @ResponseStatus(HttpStatus.CREATED)
    public String createVendor(@Valid @RequestBody Vendor vendor) {
        service.createVendor(vendor);
        return "redirect:/login?registered";
    }
}
