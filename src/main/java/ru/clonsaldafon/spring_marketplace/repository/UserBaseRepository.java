package ru.clonsaldafon.spring_marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clonsaldafon.spring_marketplace.model.UserBase;

import java.util.Optional;

public interface UserBaseRepository extends JpaRepository<UserBase, Long> {

    Optional<UserBase> findByEmail(String email);
}
