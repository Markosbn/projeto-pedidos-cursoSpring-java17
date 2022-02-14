package com.marcos.schulz.projetopedido.domain.services;

import com.marcos.schulz.projetopedido.domain.models.Order;
import com.marcos.schulz.projetopedido.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }

    public Order findById(Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.get();
    }
}
