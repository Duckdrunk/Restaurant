package com.spring.restaurant.models;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="pedidos")
@ToString @EqualsAndHashCode
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "idpedido")
    private Long idpedido;

    @Getter @Setter @Column(name = "idusuario")
    private Long idusuario;

    @Getter @Setter @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha;

    @Getter @Setter @Column(name = "estado")
    private String estado;


    public Pedido()
    {

    }

}
