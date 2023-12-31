package com.spring.restaurant.data.dataacces;

import com.spring.restaurant.data.interfaces.IDAUsuario;
import com.spring.restaurant.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class DAUsuario implements IDAUsuario {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios()
    {
        String query = "SELECT u FROM Usuario u";
        
        return entityManager.createQuery(query,Usuario.class).getResultList();
    }

    @Override
    public void delete(Long id)
    {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void register(Usuario usuario) 
    {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioCredenciales(Usuario usuario)
    {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista=entityManager.createQuery(query,Usuario.class)
                            .setParameter("email", usuario.getEmail())
                            .getResultList();

        if(lista.isEmpty()){
            return null;
        }
                 
        Argon2 argon2 =  Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);                
        if(argon2.verify(lista.get(0).getPassword()
                        ,usuario.getPassword())){
            return lista.get(0);
        }
        
        return null;
    }

    @Override
    public Usuario getUsuariobyId(Long id){        
        return  entityManager.find(Usuario.class,id);
    }

    
}
