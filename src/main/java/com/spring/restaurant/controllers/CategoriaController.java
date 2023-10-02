package com.spring.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restaurant.data.interfaces.IDACategoria;
import com.spring.restaurant.models.Categoria;

@RestController
public class CategoriaController {
    @Autowired
    private IDACategoria idaCategoria; //UsuarioDAO = IDAUsuario; UsuarioDaoImp = DAUsuario

    @GetMapping(value = "api/categorias")
    public List<Categoria> getCategorias()
    {
        return idaCategoria.getCategorias();
    }


}
