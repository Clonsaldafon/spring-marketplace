package ru.clonsaldafon.spring_marketplace.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clonsaldafon.spring_marketplace.model.User;
import ru.clonsaldafon.spring_marketplace.model.UserBase;
import ru.clonsaldafon.spring_marketplace.model.Vendor;
import ru.clonsaldafon.spring_marketplace.repository.UserBaseRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserBaseRepository repository;

    @Transactional(readOnly = true)
    public List<UserBase> getAllUsers() {
        return repository.findAll();
    }

    @Transactional
    public User createUser(User user) {
        return repository.save(user);
    }

    @Transactional
    public Vendor createVendor(Vendor vendor) {
        return repository.save(vendor);
    }
}
