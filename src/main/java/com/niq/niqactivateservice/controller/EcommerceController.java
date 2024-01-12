package com.niq.niqactivateservice.controller;/* Created by Indunil Prasanna */

import com.niq.niqactivateservice.model.Product;
import com.niq.niqactivateservice.model.Shopper;
import com.niq.niqactivateservice.service.ShopperProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eCommerce/v1/")
public class EcommerceController {

    @Autowired
    private ShopperProductService shopperProductService;

    @GetMapping("/shoppers/{id}/products")
    public Page<Product> getProductsByShopper(@PathVariable String id, @RequestParam(required = false) String category,
                                              @RequestParam(required = false) String brand,
                                              @RequestParam(defaultValue = "10") int limit) {
        return shopperProductService.getProductsByShopper(id, createPageRequest(limit));
    }

    @GetMapping("/products/{id}/shoppers")
    public Page<Shopper> getShoppersByProduct(@PathVariable String id, @RequestParam(required = false) String category,
                                              @RequestParam(required = false) String brand,
                                              @RequestParam(defaultValue = "10") int limit){
        return shopperProductService.getShoppersByProduct(id, createPageRequest(limit));
    }

    private PageRequest createPageRequest(int limit) {

        // Validate limit
        if(limit > 100) {
            limit = 100;
        }

        // Calculate page size
        int pageSize = Math.min(limit, 10);

        // Create page request
        PageRequest pageRequest = PageRequest.of(0, pageSize);

        return pageRequest;
    }

}
