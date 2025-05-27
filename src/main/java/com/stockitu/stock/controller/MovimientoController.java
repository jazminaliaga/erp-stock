package com.stockitu.stock.controller;

import com.stockitu.stock.dto.MovimientoDTO;
import com.stockitu.stock.entity.MovimientoStock;
import com.stockitu.stock.entity.TipoMovimiento;
import com.stockitu.stock.service.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarMovimiento(@RequestBody MovimientoDTO dto) {
        movimientoService.registrarMovimiento(dto);
        return ResponseEntity.ok("Movimiento registrado");
    }

    @GetMapping
    public List<MovimientoStock> listarMovimientos() {
        return movimientoService.listarMovimientos();
    }
}
