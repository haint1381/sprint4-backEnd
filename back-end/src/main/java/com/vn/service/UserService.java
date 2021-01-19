package com.vn.service;

import com.vn.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String name);
    User findById(Long id);
    void save(User user);
    List<User> findAllByStatusTrueAndRole_IdRole(Long id);
    boolean existsByUsername(String userName);
}
