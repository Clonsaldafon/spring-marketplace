package ru.clonsaldafon.spring_marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.clonsaldafon.spring_marketplace.config.CustomUserDetails;
import ru.clonsaldafon.spring_marketplace.model.UserBase;
import ru.clonsaldafon.spring_marketplace.repository.UserBaseRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserBaseRepository repository;

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserBase userBase = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email '" + email + "' not found"));

        return new CustomUserDetails(userBase);
    }
}
