package com.gabriel.amaristest.price.repository;

import com.gabriel.amaristest.price.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT * FROM prices " +
            "WHERE product_id = ?1 AND brand_id = ?2 AND ?3 BETWEEN start_date AND end_date " +
            "ORDER BY priority DESC LIMIT 1", nativeQuery = true)
    Optional<Price> findRateWithMorePriority(Long productId, Long brandId, Date applicationDate);
}
