package com.vn.controllers;


import com.vn.dto.GoodsCartDTO;
import com.vn.model.Cart;
import com.vn.model.GoodsCart;
import com.vn.model.User;
import com.vn.service.CartService;
import com.vn.service.GoodsCartService;
import com.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartControler {
    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    GoodsCartService goodsCartService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GoodsCartDTO>> getAllGoodsCart(@RequestParam("username") String username){
        User user = userService.findByUsername(username);
        List<GoodsCartDTO> goodsCartDTOList = new ArrayList<>();
        if(user ==  null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cart = user.getCart();
        List<GoodsCart> goodsCartList = (List<GoodsCart>) cart.getGoodsCollection();
       if(goodsCartList.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       for (GoodsCart goodsCart: goodsCartList){
           goodsCartDTOList.add(new GoodsCartDTO(
                   goodsCart.getIdGoodsCart(),
                   goodsCart.getIdGoods(),
                   goodsCart.getQuantityCart(),
                   goodsCart.getGoodsName(),
                   goodsCart.getPrice(),
                   goodsCart.getTradeMark(),
                   goodsCart.getSaleOff(),
                   goodsCart.getPriceForSaleOff(),
                   goodsCart.getImage(),
                   goodsCart.getCart().getIdCart()));
       }
        return new ResponseEntity<>(goodsCartDTOList,HttpStatus.OK);
    }

    @GetMapping("/findByIdGoods/{idGoods}")
    public ResponseEntity<GoodsCartDTO> findByGoodsCart(@PathVariable("idGoods") Long idGoods){
        GoodsCart goodsCart = goodsCartService.findByIdGoods(idGoods);
        if(goodsCart ==  null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        GoodsCartDTO goodsCartDTO =  new GoodsCartDTO(
                goodsCart.getIdGoodsCart(),
                goodsCart.getIdGoods(),
                goodsCart.getQuantityCart(),
                goodsCart.getGoodsName(),
                goodsCart.getPrice(),
                goodsCart.getTradeMark(),
                goodsCart.getSaleOff(),
                goodsCart.getPriceForSaleOff(),
                goodsCart.getImage(),
                goodsCart.getCart().getIdCart());
        return new ResponseEntity<>(goodsCartDTO,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addGoodsCart(@RequestBody GoodsCartDTO goodsCartDTO){
        if(cartService.finById(goodsCartDTO.getCart()) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        GoodsCart goodsCart = new GoodsCart();
        goodsCart.setIdGoods(goodsCartDTO.getIdGoods());
        goodsCart.setQuantityCart(goodsCartDTO.getQuantityCart());
        goodsCart.setGoodsName(goodsCartDTO.getGoodsName());
        goodsCart.setPrice(goodsCartDTO.getPrice());
        goodsCart.setTradeMark(goodsCartDTO.getTradeMark());
        goodsCart.setPriceForSaleOff(goodsCartDTO.getPriceForSaleOff());
        goodsCart.setSaleOff(goodsCartDTO.getSaleOff());
        goodsCart.setImage(goodsCartDTO.getImage());
        goodsCart.setCart(cartService.finById(goodsCartDTO.getCart()));
        goodsCartService.save(goodsCart);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-by-cart")
    public ResponseEntity<Long> findByCart(@RequestParam("username") String username){
        User user = userService.findByUsername(username);
        if(user ==  null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cart = user.getCart();
        return new ResponseEntity<>(cart.getIdCart(),HttpStatus.OK);
    }

    @PutMapping("/update-goods-cart")
    public ResponseEntity<Void> updateGoodsCart(@RequestParam("idGoodsCart") String idGoodsCart, @RequestBody GoodsCartDTO goodsCartDTO) {
        GoodsCart goodsCart1 = goodsCartService.findByGoodsCart(Long.parseLong(idGoodsCart));
        if (goodsCart1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            goodsCart1.setIdGoods(goodsCartDTO.getIdGoods());
            goodsCart1.setQuantityCart(goodsCartDTO.getQuantityCart());
            goodsCart1.setGoodsName(goodsCartDTO.getGoodsName());
            goodsCart1.setPrice(goodsCartDTO.getPrice());
            goodsCart1.setTradeMark(goodsCartDTO.getTradeMark());
            goodsCart1.setSaleOff(goodsCartDTO.getSaleOff());
            goodsCart1.setPriceForSaleOff(goodsCartDTO.getPriceForSaleOff());
            goodsCart1.setImage(goodsCartDTO.getImage());
            goodsCart1.setCart(cartService.finById(goodsCartDTO.getCart()));
            goodsCartService.save(goodsCart1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<Boolean> resetCart(@RequestParam("idGoodsCart") String idGoodsCart) {

        GoodsCart goodsCart = goodsCartService.findByGoodsCart(Long.parseLong(idGoodsCart));
        if(goodsCart ==  null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        goodsCartService.deleteById(Long.parseLong(idGoodsCart));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
