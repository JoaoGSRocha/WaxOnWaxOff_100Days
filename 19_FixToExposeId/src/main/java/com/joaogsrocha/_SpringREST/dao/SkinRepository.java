package com.joaogsrocha._SpringREST.dao;

import com.joaogsrocha._SpringREST.skin.Skin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@CrossOrigin("http://localhost:4200")
public interface SkinRepository extends JpaRepository<Skin, Long> {
    Page<Skin> findByExpansionId(@RequestParam("id") Long id, Pageable pageable);
    Page<Skin> findByExpansionIdAndUnitsInStockLessThanEqual(@RequestParam("id") Long id,
                                                @RequestParam("units_in_stock") Integer units_in_stock,
                                                Pageable pageable);
    Page<Skin> findByUnitsInStockLessThanEqual(@RequestParam("units_in_stock") Integer units_in_stock,
                                                             Pageable pageable);
    Page<Skin> findByPriceBetween(@RequestParam("price1") BigDecimal price1, @RequestParam("price2") BigDecimal price2,
                                  Pageable pageable);
}
