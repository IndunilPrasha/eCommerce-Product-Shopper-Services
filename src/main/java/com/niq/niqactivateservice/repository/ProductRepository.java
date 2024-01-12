package com.niq.niqactivateservice.repository;/* Created by Indunil Prasanna */

import com.niq.niqactivateservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
