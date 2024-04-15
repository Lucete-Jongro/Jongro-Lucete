package com.lucete.comprehensive.product.model.service;

import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.product.model.dao.ProductMapper;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    public void insertProduct(ProductDTO product) {

        productMapper.insertProduct(product);
    }

    public void uploadFile(MultipartFile file, ProductDTO product) throws IOException {

        String fileName = file.getOriginalFilename();
        String filePass = "/src/main/resources/static/image" + fileName;

        file.transferTo(new File(filePass));

        FileDTO fileDTO = new FileDTO();
        fileDTO.setFileName(fileName);
        fileDTO.setUploadDate(new Date());
        fileDTO.setFilePass(filePass);
        fileDTO.setFileSize((int) file.getSize());
        fileDTO.setProdSerial(product.getProdSerial()); // 일련번호

        productMapper.uploadFile(fileDTO);
    }
}
