package com.marcos.schulz.projetopedido.domain.services;

import com.marcos.schulz.projetopedido.domain.models.Category;
import com.marcos.schulz.projetopedido.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Category findById(Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.get();
    }
}
