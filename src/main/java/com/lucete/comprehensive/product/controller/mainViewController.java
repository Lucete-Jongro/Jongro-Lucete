package com.lucete.comprehensive.product.controller;

import com.lucete.comprehensive.product.model.dto.ProductDTO;
import com.lucete.comprehensive.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class mainViewController {

    @Autowired
    private ProductService productService;

    @GetMapping("/prod")
    public String prodView(Model model) {

        List<ProductDTO> productLeft = productService.getViewLeft();
        List<ProductDTO> productRight = productService.getViewRight();
        model.addAttribute("products", productLeft);
        model.addAttribute("products2", productRight);

        return "main/prod";
    }

    @GetMapping("/diyProd")
    public String diyProdView(Model model) {

        List<ProductDTO> productLeft = productService.getDiyLeft();
        List<ProductDTO> productRight = productService.getDiyRight();
        model.addAttribute("products", productLeft);
        model.addAttribute("products2", productRight);

        return "main/diyProd";
    }

    @GetMapping("/kitProd")
    public String kitProdView(Model model) {

        List<ProductDTO> productLeft = productService.getKitLeft();
        List<ProductDTO> productRight = productService.getKitRight();
        model.addAttribute("products", productLeft);
        model.addAttribute("products2", productRight);

        return "main/kitProd";
    }

    @GetMapping("/onedayclassView")
    public String odcView(Model model) {

        List<ProductDTO> productLeft = productService.getOdcLeft();
        List<ProductDTO> productRight = productService.getOdcRight();
        model.addAttribute("products", productLeft);
        model.addAttribute("products2", productRight);

        return "main/onedayclassView";
    }

    @GetMapping("/prodDetail")
    public String prodDetail(Model model, int prodSerial) {

        ProductDTO productDTO = productService.prodDetail(prodSerial);

        model.addAttribute("product", productDTO);

        return "main/prodDetail";
    }

}
