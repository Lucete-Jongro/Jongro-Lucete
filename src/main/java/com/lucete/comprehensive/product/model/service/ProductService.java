package com.lucete.comprehensive.product.model.service;

import com.lucete.comprehensive.product.model.dao.ProductMapper;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    public void insertProduct(ProductDTO product) {

        productMapper.insertProduct(product);
    }
}
