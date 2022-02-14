package com.marcos.schulz.projetopedido.domain.repositories;

import com.marcos.schulz.projetopedido.domain.models.Order;
import com.marcos.schulz.projetopedido.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
