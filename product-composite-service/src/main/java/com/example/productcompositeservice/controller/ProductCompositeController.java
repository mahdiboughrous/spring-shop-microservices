package com.example.productcompositeservice.controller;

import com.example.productcompositeservice.models.ProductComposite;
import com.example.productcompositeservice.service.ProductCompositeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/product-composites")
public class ProductCompositeController {

    private final ProductCompositeService productCompositeService;
    private final Logger logger = LoggerFactory.getLogger(ProductCompositeController.class);

    @Autowired
    public ProductCompositeController(ProductCompositeService productCompositeService) {
        this.productCompositeService = productCompositeService;
    }

    // Get all product composites
    @GetMapping("/{productId}")
    public ResponseEntity<ProductComposite> getProductComposite(@PathVariable int productId) {
        logger.info("Getting all product composites");
        ProductComposite productComposite = productCompositeService.getProductComposite(productId);
        return ResponseEntity.ok().body(productComposite);
    }

}
