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

        return "product/Insert";
    }

    @PostMapping("/Insert")
    public String insertProductAndImage(ProductDTO product, List<MultipartFile> attachImage) {

        // 상품 정보를 먼저 데이터베이스에 삽입
        productService.insertProduct(product);

        String root = "src/main/resources/static";
        String filePath = root + "/upload";

        File dir = new File(filePath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        List<FileDTO> fileList = new ArrayList<>();

        try {
            if (attachImage != null) {

                for(MultipartFile multiFile : attachImage) {

                    if (multiFile != null && multiFile.getSize() > 0) {

                        String originalFileName = multiFile.getOriginalFilename();
                        System.out.println("originalFileName : " + originalFileName );

                        String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                        String savedFileName = UUID.randomUUID() + ext;
                        System.out.println("savedFileName" + savedFileName);

                        multiFile.transferTo(new File(filePath + "/" + savedFileName));

                        FileDTO file = new FileDTO();
                        file.setFileName(savedFileName);
                        System.out.println("file.getFileName : " + file.getFileName());

                        file.setUploadDate(new Date());
                        System.out.println("file.getUploadDate() : " + file.getUploadDate());

                        file.setFilePass(filePath);
                        System.out.println("file.getFilePass() = " + file.getFilePass());

                        file.setFileSize(attachImage.size());
                        System.out.println("file.getFileSize() = " + file.getFileSize());

                        file.setRevNo(1);

                        fileList.add(file);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }

        // 이미지 파일 정보를 데이터베이스에 삽입
        for (FileDTO file : fileList) {
            // 상품 정보와 연결된 이미지 정보로 삽입
            file.setProdSerial(product.getProdSerial());
            System.out.println(file.getProdSerial());
            productService.insertImage(file);
        }

        return "redirect:/product/Insert";
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


    @GetMapping("/category")
    public String productCategory() {

        return "product/category";
    }

}
