package com.lucete.comprehensive.product.controller;

import com.lucete.comprehensive.product.model.dto.ProductCategoryDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import com.lucete.comprehensive.product.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private MessageSource messageSource;

//    @GetMapping("/Insert")
//    public void insertPage(){}

    @PostMapping("/Insert")
    public String insertProduct(@ModelAttribute ProductDTO product, RedirectAttributes rttr, Locale locale) {

        logger.info("product : {}", product);

        productService.insertProduct(product);

//        rttr.addFlashAttribute("successMessage", messageSource.getMessage("insertProduct", null, locale.KOREAN));

        return "redirect:/product/Insert";
    }

    private List<ProductCategoryDTO> categoryList = new ArrayList<>();

    // 제품 카테고리 목록을 초기화
    {
        categoryList.add(new ProductCategoryDTO(1, "쥬얼리", 1001));
        categoryList.add(new ProductCategoryDTO(2, "DIY Kit", 1002));
        categoryList.add(new ProductCategoryDTO(3, "DIY 자재", 1003));
    }

    // 제품 등록 페이지로 이동
    @GetMapping("/Insert")
    public String showInsertProductPage(Model model) {
        // 카테고리 목록을 모델에 추가하여 뷰로 전달
        model.addAttribute("categories", categoryList);
        // 제품 등록 페이지로 이동
        return "/product/Insert";
    }
}
