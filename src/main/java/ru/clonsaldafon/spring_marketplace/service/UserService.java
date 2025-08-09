package ru.clonsaldafon.spring_marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.clonsaldafon.spring_marketplace.exception.DuplicateResourceException;
import ru.clonsaldafon.spring_marketplace.exception.ResourceNotFoundException;
import ru.clonsaldafon.spring_marketplace.model.User;
import ru.clonsaldafon.spring_marketplace.model.UserBase;
import ru.clonsaldafon.spring_marketplace.model.Vendor;
import ru.clonsaldafon.spring_marketplace.repository.UserBaseRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserBaseRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserBase> getAll() {
        return repository.findAll();
    }

    public UserBase findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("User with email '" + email + "' not found")
        );
    }

    public User createUser(User user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateResourceException("User with email '" + user.getEmail() + "' already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public Vendor createVendor(Vendor vendor) {
        if (repository.findByEmail(vendor.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Vendor with email '" + vendor.getEmail() + "' already exists");
        }

        vendor.setPassword(passwordEncoder.encode(vendor.getPassword()));
        return repository.save(vendor);
    }
}
