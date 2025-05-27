package com.stockitu.stock.service;

import com.stockitu.stock.dto.MovimientoDTO;
import com.stockitu.stock.entity.MovimientoStock;
import com.stockitu.stock.entity.Producto;
import com.stockitu.stock.entity.TipoMovimiento;
import com.stockitu.stock.repository.MovimientoRepository;
import com.stockitu.stock.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    private final MovimientoRepository movimientoRepository;
    private final ProductoRepository productoRepository;

    public MovimientoService(MovimientoRepository movimientoRepository, ProductoRepository productoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.productoRepository = productoRepository;
    }

    public MovimientoStock registrarMovimiento(MovimientoDTO dto) {
        Optional<Producto> prodOpt = productoRepository.findById(dto.getProductoId());
        if (prodOpt.isEmpty()) {
            throw new RuntimeException("Producto no encontrado");
        }

        Producto prod = prodOpt.get();

        // Actualizar stock
        int stockActual = prod.getStock();
        if (dto.getTipoMovimiento() == TipoMovimiento.ENTRADA) {
            prod.setStock(stockActual + dto.getStock());
        } else if (dto.getTipoMovimiento() == TipoMovimiento.SALIDA) {
            if (dto.getStock() > stockActual) {
                throw new RuntimeException("No hay suficiente stock");
            }
            prod.setStock(stockActual - dto.getStock());
        }

        // Guardar el movimiento
        MovimientoStock mov = new MovimientoStock();
        mov.setTipoMovimiento(dto.getTipoMovimiento());
        mov.setStock(dto.getStock());
        mov.setFecha(LocalDateTime.now());
        mov.setProd(prod);

        productoRepository.save(prod); // actualiza el producto con nuevo stock
        return movimientoRepository.save(mov); // guarda movimeinto
    }

    public List<MovimientoStock> listarMovimientos() {
        return movimientoRepository.findAll();
    }
}
