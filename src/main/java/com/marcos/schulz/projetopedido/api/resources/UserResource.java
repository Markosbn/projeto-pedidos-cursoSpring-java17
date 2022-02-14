package com.marcos.schulz.projetopedido.api.resources;

import com.marcos.schulz.projetopedido.domain.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> testList = new ArrayList<>();
        User test = new User(1L, "Marcos", "marcos@gmail.com", "48 999996666", "123456");
        testList.add(test);
        return ResponseEntity.ok().body(testList);
    }
}
