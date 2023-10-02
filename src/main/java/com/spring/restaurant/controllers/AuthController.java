package com.spring.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restaurant.data.interfaces.IDAUsuario;
import com.spring.restaurant.models.Usuario;
import com.spring.restaurant.utils.JWTUtil;

@RestController
public class AuthController {

    @Autowired
    private IDAUsuario idaUsuario;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value="api/login")
    public String login(@RequestBody Usuario usuario)
    {
        Usuario usuarioLogueado= idaUsuario.obtenerUsuarioCredenciales(usuario);
        if(usuarioLogueado!=null){
            //Token JWT
            return jwtUtil.create(String.valueOf(usuarioLogueado.getIdusuario()), usuarioLogueado.getEmail());
        }
        return "FAIL";
    }
}
