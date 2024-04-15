package com.lucete.comprehensive.product.model.dao;

import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    void insertProduct(ProductDTO product);
}
