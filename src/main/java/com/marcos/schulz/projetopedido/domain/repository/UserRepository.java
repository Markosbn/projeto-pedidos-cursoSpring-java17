package com.marcos.schulz.projetopedido.domain.repository;

import com.marcos.schulz.projetopedido.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
