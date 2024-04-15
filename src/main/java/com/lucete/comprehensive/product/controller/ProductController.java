package com.lucete.comprehensive.product.controller;

import com.lucete.comprehensive.product.model.dto.ProductCategoryDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import com.lucete.comprehensive.product.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/Insert")
    public void insertPage(){}

    @PostMapping("/Insert")
    public String insertProduct(@ModelAttribute ProductDTO product, RedirectAttributes rttr, Locale locale) {

        logger.info("product : {}", product);

        productService.insertProduct(product);

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("insertProduct", null, locale));

        return "redirect:/product/Insert";
    }
}
