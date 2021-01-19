package com.vn.repository;

import com.vn.model.Cart;
import com.vn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    User findUserByEmail(String name);

    List<User> findAllByStatusTrueAndRole_IdRole(Long id);

    boolean existsByUsername(String userName);
}
