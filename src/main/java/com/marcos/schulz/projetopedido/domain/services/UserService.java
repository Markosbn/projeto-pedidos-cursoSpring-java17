package com.marcos.schulz.projetopedido.domain.services;

import com.marcos.schulz.projetopedido.domain.models.User;
import com.marcos.schulz.projetopedido.domain.repositories.UserRepository;
import com.marcos.schulz.projetopedido.domain.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User findById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new ResourceNotFoundException(id)); //Alterado o .get para .orElseThrow, para que lance excessão de não retornar nada no optional
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete (Long id){
        userRepository.deleteById(id);
    }

    public User update (Long id, User obj){
        User user = userRepository.getById(id);
        updateData(user, obj);
        return userRepository.save(user);
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }

}
