package com.vn.service;



import com.vn.model.Goods;
import com.vn.model.GoodsCart;

import java.util.List;

public interface GoodsCartService {
    void save(GoodsCart goodsCart);
    List<GoodsCart> getAll();
    GoodsCart findByGoodsCart(Long id);
    GoodsCart findByIdGoodsStatus(Long id);
    void deleteById(Long id);
    List<GoodsCart> findGoodsCartByCart_IdCartAndStatusTrue(Long id);
    List<GoodsCart> findAllByStatusTrue(Boolean value);
}
