package com.spring.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restaurant.data.interfaces.IDAProducto;

import com.spring.restaurant.models.Producto;

//import com.spring.restaurant.utils.JWTUtil;

@RestController
public class ProductoController {
    @Autowired
    private IDAProducto idaProducto;

    //@Autowired
    //private JWTUtil jwtUtil;

    @GetMapping("api/productos")
    public List<Producto> getProductos()
    {
        return idaProducto.getProductos();   
    }

    @RequestMapping("api/productos/{idcategoria}")
    public List<Producto> getProductobyCategoria(@PathVariable Long idcategoria){
        return idaProducto.getProductobyCategoria(idcategoria);
    }
}
