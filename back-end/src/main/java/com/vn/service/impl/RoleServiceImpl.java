package com.vn.service.impl;

import com.vn.model.Role;
import com.vn.repository.RoleRepository;
import com.vn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
