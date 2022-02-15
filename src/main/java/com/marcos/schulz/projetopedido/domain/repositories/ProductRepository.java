package com.marcos.schulz.projetopedido.domain.repositories;

import com.marcos.schulz.projetopedido.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
