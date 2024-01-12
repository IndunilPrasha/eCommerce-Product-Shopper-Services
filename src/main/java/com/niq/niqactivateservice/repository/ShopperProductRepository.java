package com.niq.niqactivateservice.repository;/* Created by Indunil Prasanna */

import com.niq.niqactivateservice.model.Product;
import com.niq.niqactivateservice.model.Shopper;
import com.niq.niqactivateservice.model.ShopperProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopperProductRepository extends JpaRepository<ShopperProduct, Long> {

    @Query("SELECT p FROM ShopperProduct sp JOIN Product p ON sp.product.id = p.id WHERE sp.shopper.id = :shopperId")
    Page<Product> findByShopperId(@Param("shopperId") String shopperId, Pageable page);

    @Query("SELECT DISTINCT sp.shopper FROM ShopperProduct sp WHERE sp.product.id = :productId")
    Page<Shopper> findShoppersByProductId(@Param("productId") String productId, Pageable page);
}
