package com.vn.service.impl;

import com.vn.model.Goods;
import com.vn.repository.GoodsRepository;
import com.vn.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsRepository goodsRepository;

    @Override
    public List<Goods> findAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public List<Goods> findAllByCategory_IdCategory(Long id) {
        return goodsRepository.findAllByCategory_IdCategory(id);
    }
}
