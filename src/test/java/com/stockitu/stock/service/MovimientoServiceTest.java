package com.stockitu.stock.service;

import com.stockitu.stock.dto.MovimientoDTO;
import com.stockitu.stock.entity.MovimientoStock;
import com.stockitu.stock.entity.Producto;
import com.stockitu.stock.entity.TipoMovimiento;
import com.stockitu.stock.repository.MovimientoRepository;
import com.stockitu.stock.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MovimientoServiceTest {
    private MovimientoRepository movimientoRepository;
    private ProductoRepository productoRepository;
    private MovimientoService movimientoService;

    @BeforeEach
    void setUp() {
        movimientoRepository = mock(MovimientoRepository.class);
        productoRepository = mock(ProductoRepository.class);
        movimientoService = new MovimientoService(movimientoRepository, productoRepository);
    }

    @Test
    void registrarEntrada_deberiaActualizarStockCorrectamente() {
        Producto prod = new Producto();
        prod.setNombre("Producto Test");
        prod.setStock(10);
        MovimientoDTO dto = new MovimientoDTO();
        dto.setProductoId(1);
        dto.setTipoMovimiento(TipoMovimiento.ENTRADA);
        dto.setStock(5);

        when(productoRepository.findById(1)).thenReturn(Optional.of(prod));
        when(productoRepository.save(any(Producto.class))).thenAnswer(i -> i.getArgument(0));
        when(movimientoRepository.save(any(MovimientoStock.class))).thenAnswer(i -> i.getArgument(0));

        MovimientoStock resultado = movimientoService.registrarMovimiento(dto);

        assertEquals(15, prod.getStock());
        assertEquals(TipoMovimiento.ENTRADA, resultado.getTipoMovimiento());
    }

    @Test
    void registrarSalida_deberiaActualizarStockCorrectamente() {
        Producto prod = new Producto();
        prod.setNombre("Producto Test");
        prod.setStock(20);
        MovimientoDTO dto = new MovimientoDTO();
        dto.setProductoId(1);
        dto.setTipoMovimiento(TipoMovimiento.SALIDA);
        dto.setStock(5);

        when(productoRepository.findById(1)).thenReturn(Optional.of(prod));
        when(productoRepository.save(any(Producto.class))).thenAnswer(i -> i.getArgument(0));
        when(movimientoRepository.save(any(MovimientoStock.class))).thenAnswer(i -> i.getArgument(0));

        MovimientoStock resultado = movimientoService.registrarMovimiento(dto);

        assertEquals(15, prod.getStock());
        assertEquals(TipoMovimiento.SALIDA, resultado.getTipoMovimiento());
    }

    @Test
    void registrarMovimiento_productoNoExiste_deberiaLanzarExcepcion() {
        MovimientoDTO dto = new MovimientoDTO();
        dto.setProductoId(999);
        dto.setTipoMovimiento(TipoMovimiento.ENTRADA);
        dto.setStock(5);

        when(productoRepository.findById(999)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            movimientoService.registrarMovimiento(dto);
        });

        assertTrue(ex.getMessage().contains("Producto no encontrado"));
    }

    @Test
    void registrarSalida_sinStockSuficiente_deberiaLanzarExcepcion() {
        Producto prod = new Producto();
        prod.setNombre("Producto Test");
        prod.setStock(3);
        MovimientoDTO dto = new MovimientoDTO();
        dto.setProductoId(1);
        dto.setTipoMovimiento(TipoMovimiento.SALIDA);
        dto.setStock(5); // mayor que stock actual

        when(productoRepository.findById(1)).thenReturn(Optional.of(prod));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            movimientoService.registrarMovimiento(dto);
        });

        assertTrue(ex.getMessage().contains("No hay suficiente stock"));
    }
}
