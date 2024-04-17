package com.lucete.comprehensive.product.model.service;

import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.product.controller.ProductController;
import com.lucete.comprehensive.product.model.dao.ProductMapper;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    public void insertProduct(ProductDTO product) {

        productMapper.insertProduct(product);
    }

    public void insertImage(FileDTO fileDTO) {

        productMapper.insertImage(fileDTO);
    }

}
