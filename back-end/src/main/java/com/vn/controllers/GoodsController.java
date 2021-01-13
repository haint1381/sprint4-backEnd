package com.vn.controllers;

import com.vn.model.Cart;
import com.vn.model.Goods;
import com.vn.model.User;
import com.vn.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Goods>> getAllGoods(){
        List<Goods> goodsList = goodsService.findAllGoods();
        if(goodsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @GetMapping("/searchByGoodsType")
    public ResponseEntity<List<Goods>> searchByGoodsType(@RequestParam("valueSearch") String valueSearch){
        List<Goods> goodsList = goodsService.findAllByCategory_IdCategory(Long.parseLong(valueSearch));
        return new ResponseEntity<>(goodsList,HttpStatus.OK);
    }

}
