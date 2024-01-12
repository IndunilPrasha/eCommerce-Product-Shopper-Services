package com.niq.niqactivateservice.service;/* Created by Indunil Prasanna */

import com.niq.niqactivateservice.model.Product;
import com.niq.niqactivateservice.model.Shopper;
import com.niq.niqactivateservice.repository.ShopperProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ShopperProductServiceImpl implements ShopperProductService{

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int MAX_PAGE_SIZE = 100;

    @Autowired
    private ShopperProductRepository shopperProductRepository;

    @Override
    public Page<Product> getProductsByShopper(String shopperId, PageRequest filters) {

        // Create PageRequest
        int pageSize = Math.min(filters.getPageSize(), MAX_PAGE_SIZE);
        pageSize = Math.min(pageSize, DEFAULT_PAGE_SIZE);

        PageRequest pageRequest = PageRequest.of(0, pageSize);
        return shopperProductRepository.findByShopperId(shopperId, pageRequest);
    }

    @Override
    public Page<Shopper> getShoppersByProduct(String productId, PageRequest filters) {

        // Create PageRequest
        int pageSize = Math.min(filters.getPageSize(), MAX_PAGE_SIZE);
        pageSize = Math.min(pageSize, DEFAULT_PAGE_SIZE);

        PageRequest pageRequest = PageRequest.of(0, pageSize);
        return shopperProductRepository.findShoppersByProductId(productId, pageRequest);
    }
}
