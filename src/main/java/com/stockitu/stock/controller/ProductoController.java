package com.stockitu.stock.controller;

import com.stockitu.stock.entity.Producto;
import com.stockitu.stock.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto prod) {
        return productoService.crearProducto(prod);
    }

    @GetMapping("/{id}")
    public Producto traerProducto(@PathVariable Integer id) {
        return productoService.traerProducto(id);
    }

    @GetMapping
    public List<Producto> traerTodo() {
        return productoService.traerTodo();
    }

}
