package com.stockitu.stock.repository;

import com.stockitu.stock.entity.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<MovimientoStock, Integer> {
}
