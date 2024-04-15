package com.lucete.comprehensive.product.model.dao;

import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    void insertProduct(@Param("product") ProductDTO product);

    void uploadFile(@Param("fileDTO") FileDTO fileDTO);
}
