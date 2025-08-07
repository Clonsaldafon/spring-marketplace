package ru.clonsaldafon.spring_marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clonsaldafon.spring_marketplace.model.UserBase;

public interface UserBaseRepository extends JpaRepository<UserBase, Long> {
}
