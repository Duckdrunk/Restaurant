package com.spring.restaurant.data.interfaces;

import java.util.List;

import com.spring.restaurant.models.Pedido;

public interface IDAPedido {
    List<Pedido> getPedidos();

    void register(Long id);

    void delete(Pedido pedido);
    
}
