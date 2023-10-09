package com.spring.restaurant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="productos")
@ToString @EqualsAndHashCode
public class Producto 
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "idproducto")
    private Long idproducto;

    @ManyToOne @JoinColumn(name="idcategoria")
    @Getter @Setter
    private Categoria categoria;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "descripcion")
    private String descripcion;

    @Getter @Setter @Column(name = "precio")
    private double precio;

    @Getter @Setter @Column(name = "imagen")
    private String imagen;

    private Producto()
    {

    }

}
