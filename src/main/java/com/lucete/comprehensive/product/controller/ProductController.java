package com.lucete.comprehensive.product.controller;


import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.product.model.dto.ProductCategoryDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import com.lucete.comprehensive.product.model.service.ProductService;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/Insert")
    public String getInsertPage(Model model){

        List<ProductCategoryDTO> categoryList = productService.getCategoryList();

        model.addAttribute("categories", categoryList);

        return "/product/Insert";
    }

    @PostMapping("/Insert")
    @ResponseBody
    public String insertProductAndImage(@RequestParam("prodCategory") String prodCategoryStr,
                                        @RequestParam("prodName") String prodName,
                                        @RequestParam("prodAmount") String prodAmountStr,
                                        @RequestParam("prodPrice") String prodPriceStr,
                                        @RequestParam("prodAccount") String prodAccount,
                                        @RequestParam(value = "attachImage") MultipartFile attachImage) {

        System.out.println("prodCategory = " + prodCategoryStr);
        System.out.println("prodName = " + prodName);
        System.out.println("attachImage = " + attachImage);

        int prodCategory = Integer.parseInt(prodCategoryStr);
        int prodAmount = Integer.parseInt(prodAmountStr);
        int prodPrice = Integer.parseInt(prodPriceStr);

        boolean isSuccess = productService.insertProduct(prodCategory, prodName, prodAmount, prodPrice, prodAccount);

        if (isSuccess) {

            System.out.println("서비스 넘어감");

            ProductDTO product = productService.insertSerial(prodName);

            if (product == null) {
                System.out.println("존재 x");
                throw new RuntimeException("해당 상품 x");
            }

            if (attachImage != null) {
            boolean isFileUpload = productService.insertFile(attachImage, product);

                if (isFileUpload) {
                    return "등록";
                } else {
                    return "실패";
                }
            } else {
                return "실패";
            }

        } else {
            return "실패";
        }


    }

    @GetMapping("/select")
    public String productSelect(Model model,
                                @RequestParam(defaultValue = "1") int page,
                                @RequestParam(required = false) String searchCondition,
                                @RequestParam(required = false) String searchValue) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        System.out.println("searchCondition : " + searchCondition);
        searchMap.put("searchValue", searchValue);
        System.out.println("searchValue : " + searchValue);
        System.out.println("searchMap : " + searchMap);

        Map<String, Object> productSelectPaging = productService.productSelect(searchMap, page);
        model.addAttribute("paging", productSelectPaging.get("paging"));
        model.addAttribute("productList", productSelectPaging.get("productList"));
        System.out.println("productSelectPaging = " + productSelectPaging);

        return "product/select";
    }

    @GetMapping("/modify")
    public String categorySelect(Model model) {

        List<ProductDTO> productList = productService.findProductList();
        model.addAttribute("products", productList);

        return "product/modify";
    }

//    @GetMapping("/information")
//    public String selectBySerial(@RequestParam(value = "prodSerial", required = false)Integer prodSerial){
//
//        System.out.println("prodSerial = " + prodSerial);
//
//         String value = productService.selectBySerial(prodSerial);
//
//
//         return value;
//    }

    @GetMapping("/information")
    @ResponseBody
    public ProductDTO selectBySerial(@RequestParam(value = "prodSerial", required = false)Integer prodSerial){

        System.out.println("prodSerial = " + prodSerial);

        ProductDTO product  = productService.selectBySerial(prodSerial);

        System.out.println("ajax 복귀");
        return product;
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateProduct(@RequestParam("prodSerial") String prodSerial,
                                @RequestParam("prodName") String prodName,
                                @RequestParam("prodAmount") int prodAmount,
                                @RequestParam("prodPrice") int prodPrice,
                                @RequestParam("prodAccount") String prodAccount) {

        boolean isSuccess = productService.updateProduct(prodSerial, prodName, prodAmount, prodPrice, prodAccount);
        if(isSuccess) {
            return "상품 정보 업데이트";
        } else {
            return "실패";
        }
    }


    @GetMapping("/category")
    public String productCategory() {

        return "product/category";
    }


}
