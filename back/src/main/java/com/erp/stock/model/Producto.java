package com.erp.stock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    private String descripcion;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private double precio;

    // ⚠️ Constructor vacío para JPA
    public Producto() {
    }

    public Producto(int id, String nombre, String marca, String descripcion, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
