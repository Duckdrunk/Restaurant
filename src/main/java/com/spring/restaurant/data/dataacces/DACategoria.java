package com.spring.restaurant.data.dataacces;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.restaurant.data.interfaces.IDACategoria;
import com.spring.restaurant.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
public class DACategoria implements IDACategoria{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Categoria> getCategorias() 
    {
        String query = "FROM Categoria";
        return entityManager.createQuery(query,Categoria.class).getResultList();    
    }


    
}
