package com.marcos.schulz.projetopedido.domain.repositories;

import com.marcos.schulz.projetopedido.domain.models.OrderItem;
import com.marcos.schulz.projetopedido.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
