package com.spring.restaurant.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="categorias")
@ToString @EqualsAndHashCode
public class Categoria {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="idcategoria")
    private Long idcategoria;

    @Getter @Setter @Column(name="nombre")
    private String nombre;


    public Categoria(){}
}
