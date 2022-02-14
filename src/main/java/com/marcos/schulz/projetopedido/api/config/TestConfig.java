package com.marcos.schulz.projetopedido.api.config;

import com.marcos.schulz.projetopedido.domain.model.User;
import com.marcos.schulz.projetopedido.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

//classe criada para excutar operações no perfil teste.
//definido como classe de configuração e implementado CommandLineRunner, para executar algo na iniciação
@Configuration
//definido o profile que vai executar
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    //implementado a inserção de usuarios no bd teste
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
