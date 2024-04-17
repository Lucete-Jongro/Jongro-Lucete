package com.lucete.comprehensive.product.model.dao;

import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    void insertProduct(ProductDTO productDTO);

    void insertImage(FileDTO fileDTO);
}
