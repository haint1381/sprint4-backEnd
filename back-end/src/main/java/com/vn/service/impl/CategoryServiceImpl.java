package com.vn.service.impl;

import com.vn.model.Category;
import com.vn.repository.CategoryRepository;
import com.vn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
