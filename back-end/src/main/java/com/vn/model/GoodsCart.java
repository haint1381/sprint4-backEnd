package com.vn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class GoodsCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGoodsCart;
    private Long idGoods;
    private String quantityCart;
    private String goodsName;
    private String price;
    private String tradeMark;
    private String saleOff;
    private String priceForSaleOff;
    private String image;

    @ManyToOne
    @JoinColumn(name = "idCart")
    @JsonIgnoreProperties("goodsCartCollection")
    private Cart cart;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(String saleOff) {
        this.saleOff = saleOff;
    }

    public String getPriceForSaleOff() {
        return priceForSaleOff;
    }

    public void setPriceForSaleOff(String priceForSaleOff) {
        this.priceForSaleOff = priceForSaleOff;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getIdGoodsCart() {
        return idGoodsCart;
    }

    public void setIdGoodsCart(Long idGoodsCart) {
        this.idGoodsCart = idGoodsCart;
    }

    public Long getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(Long idGoods) {
        this.idGoods = idGoods;
    }

    public String getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(String quantityCart) {
        this.quantityCart = quantityCart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
