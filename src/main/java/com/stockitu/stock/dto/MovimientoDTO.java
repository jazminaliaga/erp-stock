package com.stockitu.stock.dto;

import com.stockitu.stock.entity.TipoMovimiento;
import lombok.Data;

@Data
public class MovimientoDTO {
    private int productoId;
    private TipoMovimiento tipoMovimiento;
    private int stock;
}