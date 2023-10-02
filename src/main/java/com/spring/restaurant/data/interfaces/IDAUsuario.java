package com.spring.restaurant.data.interfaces;

import com.spring.restaurant.models.Usuario;

import java.util.List;

public interface IDAUsuario {

    List<Usuario> getUsuarios();

    void delete(Long id);

    void register(Usuario usuario);

    Usuario obtenerUsuarioCredenciales(Usuario usuario);

    Usuario getUsuariobyId(Long id);
}
