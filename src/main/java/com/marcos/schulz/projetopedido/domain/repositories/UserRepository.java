package com.marcos.schulz.projetopedido.domain.repositories;

import com.marcos.schulz.projetopedido.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
