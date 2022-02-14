package com.marcos.schulz.projetopedido.domain.models.enums;

public enum OrderStatus {

    //em Parenteses, declarado os codigos para cada tipo enumerado
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    //Criado os metodos para acessar por codigo, os tipos enumerados
    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid order status code!!");
    }
}
