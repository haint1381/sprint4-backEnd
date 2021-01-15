package com.vn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBill;
    private String createdDate;
    private Boolean billType;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("bill")
    private Collection<GoodsCart> goodsCartCollection;

    @ManyToOne()
    @JoinColumn(name = "idUser")
    @JsonIgnoreProperties("billCollection")
    private User user;

    public Collection<GoodsCart> getGoodsCartCollection() {
        return goodsCartCollection;
    }

    public void setGoodsCartCollection(Collection<GoodsCart> goodsCartCollection) {
        this.goodsCartCollection = goodsCartCollection;
    }

    public Long getIdBill() {
        return idBill;
    }

    public void setIdBill(Long idBill) {
        this.idBill = idBill;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getBillType() {
        return billType;
    }

    public void setBillType(Boolean billType) {
        this.billType = billType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
