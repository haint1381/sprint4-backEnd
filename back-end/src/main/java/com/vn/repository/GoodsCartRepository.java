package com.vn.repository;

import com.vn.model.GoodsCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoodsCartRepository extends JpaRepository<GoodsCart,Long> {
    String BY_ID_GOODS = "select* from goods_cart " + "where id_goods = ?1";

    @Query(value = BY_ID_GOODS, nativeQuery = true)
    GoodsCart findByIdGoods(Long id);
}
