package com.marcos.schulz.projetopedido.domain.models.pk;

import com.marcos.schulz.projetopedido.domain.models.Order;
import com.marcos.schulz.projetopedido.domain.models.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

//Classe relacional, criada para armazenar as relações pedidos x produtos(chave relacional para itens pedidos)
@Embeddable
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    //define que a muitos pedidos para um produto
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    //define que ha muitos produtos para um pedido
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //hash e equals usa ambos os campos para comparação
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
