package com.marcos.schulz.projetopedido.domain.repositories;

import com.marcos.schulz.projetopedido.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
