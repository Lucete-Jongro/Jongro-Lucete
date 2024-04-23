package com.lucete.comprehensive.product.model.service;


import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.common.paging.Pagenation;
import com.lucete.comprehensive.common.paging.SelectCriteria;
import com.lucete.comprehensive.product.controller.ProductController;
import com.lucete.comprehensive.product.model.dao.ProductMapper;
import com.lucete.comprehensive.product.model.dto.ProductCategoryDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;

    }

    public List<ProductCategoryDTO> getCategoryList() {

        List<ProductCategoryDTO> categoryList = productMapper.findCategory();

        return categoryList;
    }

    public void insertProduct(ProductDTO product) {

        productMapper.insertProduct(product);
    }

    public void insertImage(FileDTO fileDTO) {

        productMapper.insertImage(fileDTO);
    }

    public Map<String, Object> productSelect(Map<String, String> searchMap, int page) {

        // 1. 전체 게시글 수 확인
        int totalCount = productMapper.selectTotalCount(searchMap);
        System.out.println("totalCount = " + totalCount);

        // 2. 페이징 처리 관련 계산 후 SelectCriteria 담는다.
        int limit = 10;
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
        selectCriteria.setSearchCondition(searchMap.get("searchCondition"));
        selectCriteria.setSearchValue(searchMap.get("searchValue"));
        System.out.println("selectCriteria = " + selectCriteria);

        // 3. 페이지 검색 기준에 맞는 게시글 조회
        List<ProductDTO> productList = productMapper.selectProductList(selectCriteria);
        System.out.println("productList = " + productList);

        Map<String , Object> productListAndPaging = new HashMap<>();
        productListAndPaging.put("paging", selectCriteria);
        productListAndPaging.put("productList", productList);

        return productListAndPaging;
    }



    public List<ProductDTO> findProductList() {
        return productMapper.findProductList();
    }

    public ProductDTO selectBySerial(Integer prodSerial) {

        return productMapper.selectBySerial(prodSerial);
    }

    public boolean updateProduct(String prodSerial, String prodName, int prodAmount, int prodPrice, String prodAccount) {

        int rowAffected = productMapper.updateProduct(prodSerial, prodName, prodAmount, prodPrice, prodAccount);

        return rowAffected > 0;
    }

}
