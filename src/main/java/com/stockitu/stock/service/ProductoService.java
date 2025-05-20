package com.stockitu.stock.service;

import com.stockitu.stock.entity.Producto;
import com.stockitu.stock.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto traerProducto(Integer id) {
        return productoRepository.findById(id).get();
    }

    public List<Producto> traerTodo() {
        return productoRepository.findAll();
    }
}
