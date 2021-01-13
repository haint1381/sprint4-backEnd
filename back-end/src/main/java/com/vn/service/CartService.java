package com.vn.service;

import com.vn.model.Cart;

import java.util.List;

public interface CartService {
    void save(Cart cart);
    List<Cart> getAll();
    Cart finById(Long id);
}
