package com.spring.restaurant.data.dataacces;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.restaurant.data.interfaces.IDAProducto;
import com.spring.restaurant.models.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class DAProducto implements IDAProducto{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Producto> getProductos() 
    {
        String query = "SELECT p FROM Producto p";
        return entityManager.createQuery(query,Producto.class).getResultList();
    }
    
    @Override 
    public List<Producto> getProductobyCategoria(Long id)
    {
        String query = "FROM Producto WHERE categoria.idcategoria= :id";
        return entityManager.createQuery(query, Producto.class)
                            .setParameter("id", id)
                            .getResultList();
    }
}
