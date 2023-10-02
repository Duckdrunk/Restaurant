package com.spring.restaurant.data.interfaces;

import java.util.List;

import com.spring.restaurant.models.Producto;

public interface IDAProducto {
    
    List<Producto> getProductos();
    List<Producto> getProductobyCategoria(Long id);
    
}
