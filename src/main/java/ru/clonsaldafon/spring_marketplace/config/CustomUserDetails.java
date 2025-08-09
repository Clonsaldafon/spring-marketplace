package ru.clonsaldafon.spring_marketplace.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.clonsaldafon.spring_marketplace.model.UserBase;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final UserBase userBase;

    public CustomUserDetails(UserBase userBase) {
        this.userBase = userBase;
    }

    public String getName() {
        return userBase.getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + userBase.getRole());
    }

    @Override
    public String getPassword() {
        return userBase.getPassword();
    }

    @Override
    public String getUsername() {
        return userBase.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
