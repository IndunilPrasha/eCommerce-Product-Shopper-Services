package com.niq.niqactivateservice.service;/* Created by Indunil Prasanna */

import com.niq.niqactivateservice.model.Product;
import com.niq.niqactivateservice.model.Shopper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface ShopperProductService {

    Page<Product> getProductsByShopper(String shopperId, PageRequest filters);

    Page<Shopper> getShoppersByProduct(String productId, PageRequest filters);
}
