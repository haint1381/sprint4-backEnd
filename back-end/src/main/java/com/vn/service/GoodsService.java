package com.vn.service;

import com.vn.model.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> findAllGoods();
    List<Goods> findAllByCategory_IdCategory(Long id);
}
