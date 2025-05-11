package com.erp.stock.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MovimientoStock {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    private int cantidad;

    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    // ⚠️ Constructor vacío para JPA
    public MovimientoStock() {
    }

    public MovimientoStock(int id, TipoMovimiento tipo, int cantidad, LocalDateTime fecha, Producto producto) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
