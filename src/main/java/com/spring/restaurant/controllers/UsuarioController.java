package com.spring.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;

import com.spring.restaurant.data.interfaces.IDAUsuario;
import com.spring.restaurant.models.Usuario;
import com.spring.restaurant.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {

    @Autowired
    private IDAUsuario idaUsuario; //UsuarioDAO = IDAUsuario; UsuarioDaoImp = DAUsuario

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token)
    {
        if(!validarToken(token)){
            return null;
        }
        return idaUsuario.getUsuarios();
    }

    private boolean validarToken(String token)
    {
        String usuarioId= jwtUtil.getKey(token);
        return usuarioId !=null;
    }

    @PostMapping("api/usuarios")
    public void registerUsuarios(@RequestBody Usuario usuario)
    {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        usuario.setPassword(argon2.hash(1, 1024,1,usuario.getPassword()));
        idaUsuario.register(usuario);
    }

    @DeleteMapping("api/usuarios/{id}")
    public void deleteUsuario(@RequestHeader(value = "Authorization") String token,@PathVariable Long id)
    {
        idaUsuario.delete(id); 
    }


}
