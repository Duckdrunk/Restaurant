package com.spring.restaurant.data.dataacces;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.restaurant.data.interfaces.IDAPedido;
import com.spring.restaurant.models.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class DAPedido implements IDAPedido{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override 
    @Transactional
    public List<Pedido> getPedidos()
    {
        String query = "FROM Pedido";
        return entityManager.createQuery(query, Pedido.class).getResultList();
    }


    @Override
    public void register(Long id) {
        
    }
    @Override
    public void delete(Pedido pedido) {
       
    }

    
}
