package com.marcos.schulz.projetopedido.domain.services;

import com.marcos.schulz.projetopedido.domain.models.Category;
import com.marcos.schulz.projetopedido.domain.models.Product;
import com.marcos.schulz.projetopedido.domain.repositories.ProductRepository;
import com.marcos.schulz.projetopedido.domain.services.exceptions.DatabaseException;
import com.marcos.schulz.projetopedido.domain.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Product findById(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product product){
        return productRepository.save(product);
    }

    public Product update (Long id, Product obj){
        try{
            Product product = productRepository.getById(id);
            updateData(product, obj);
            return productRepository.save(product);
        }
        catch (EntityNotFoundException e ){
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id){
        try {
            productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    //metodo auxiliar para update do produto
    private void updateData(Product product, Product obj) {
        product.setName(obj.getName());
        product.setDescription(obj.getDescription());
        product.setPrice(obj.getPrice());
        product.setImgUrl(obj.getImgUrl());
    }

}
