package com.marcos.schulz.projetopedido.domain.services;

import com.marcos.schulz.projetopedido.domain.models.User;
import com.marcos.schulz.projetopedido.domain.repositories.UserRepository;
import com.marcos.schulz.projetopedido.domain.services.exceptions.DatabaseException;
import com.marcos.schulz.projetopedido.domain.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try {
            User user = userRepository.getById(id);
            updateData(user, obj);
            return userRepository.save(user);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    //metodo auxiliar para update do usuerio
    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }

}
