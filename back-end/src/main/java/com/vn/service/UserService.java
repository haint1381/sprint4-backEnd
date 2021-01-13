package com.vn.service;

import com.vn.model.User;

public interface UserService {
    User findByUsername(String name);
}
