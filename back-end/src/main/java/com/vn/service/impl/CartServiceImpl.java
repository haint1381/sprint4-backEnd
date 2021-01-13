package com.vn.service.impl;

import com.vn.model.Cart;
import com.vn.model.Goods;
import com.vn.repository.CartRepository;
import com.vn.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart finById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }
}
