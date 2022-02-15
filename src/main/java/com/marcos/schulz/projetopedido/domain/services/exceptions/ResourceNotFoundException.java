package com.marcos.schulz.projetopedido.domain.services.exceptions;

//classe para lançar excessão dos servições, para os quando estourar excessões de ResourceNotFound
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
