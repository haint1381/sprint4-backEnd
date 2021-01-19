package com.vn.service.impl;

import com.vn.model.Bill;
import com.vn.repository.BillRepository;
import com.vn.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Bill findById(Long id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bill> findAllBillById_User(Long id) {
        return billRepository.findAllBillById_User(id);
    }
}
