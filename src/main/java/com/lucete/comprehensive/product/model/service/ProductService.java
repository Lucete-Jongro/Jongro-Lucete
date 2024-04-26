package com.lucete.comprehensive.product.model.service;

import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.common.paging.Pagenation;
import com.lucete.comprehensive.common.paging.SelectCriteria;
import com.lucete.comprehensive.product.controller.ProductController;
import com.lucete.comprehensive.product.model.dao.ProductMapper;
import com.lucete.comprehensive.product.model.dto.OneDayClassDTO;
import com.lucete.comprehensive.product.model.dto.ProductCategoryDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

@Service
public class ProductService {

    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductMapper productMapper;


    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;

    }

    public List<ProductCategoryDTO> getCategoryList() {

        List<ProductCategoryDTO> categoryList = productMapper.findCategory();

        return categoryList;
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


    public boolean insertClass(String className, Date startDate, Date endDate, Time setTime, int prodPrice, String teacherName, String prodAccount) {

        int Affected = productMapper.insertClass(className, startDate, endDate, setTime, teacherName);
        int Affected2 = productMapper.classProduct(prodPrice, prodAccount, className);

        return Affected2 > 0 && Affected > 0 ;
    }

    public boolean classFile(MultipartFile file, ProductDTO product) {


//        //경로 지정
//        String root = "src/main/resources/static";
//
//        //경로 파일 지정
//        String uploadPath = root + "/upload";
//
//        //디렉토리 지정
//        File dir = new File(uploadPath);

        String uploadPath = IMAGE_DIR;

        File dir = new File(uploadPath);

        if(!dir.exists()) {
            dir.mkdirs();
        }

        try {
            String originalFileName = file.getOriginalFilename();
            String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
            String savedFileName = UUID.randomUUID() + ext;
            System.out.println("savedFileName = " + savedFileName);

            String filePath = uploadPath + "/" + savedFileName;

            System.out.println("filePath 경로 : " + filePath);

            file.transferTo(new File(filePath));


            FileDTO fileDTO = new FileDTO();
            fileDTO.setUploadDate(new Date());
            fileDTO.setFileName(savedFileName);
            fileDTO.setFilePass(filePath);
            fileDTO.setFileSize((int) file.getSize());
            fileDTO.setProdSerial(product.getProdSerial());

            System.out.println(" file PATH !!!!!!!!!!!!!!!!!! "+fileDTO.getFilePass());

            System.out.println("매퍼 들어감");
            productMapper.classFile(fileDTO);


        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("반환");

        return true;
    }

    public ProductDTO getSerial(String className) {
        return productMapper.getSerial(className);
    }

    public List<ProductDTO> getList() {

        return productMapper.getList();
    }


    public List<OneDayClassDTO> findClass() {

        return productMapper.findClass();
    }

    public OneDayClassDTO selectByClassNo(Integer classNo) {

        return productMapper.selectByClassNo(classNo);
    }

    public ProductDTO prodByClass(OneDayClassDTO oneDayClass) {

        return productMapper.prodByClass(oneDayClass);
    }

    public boolean updateClass(String classNo, String className, Date startDate, Date endDate, Time setTime) {

        int Affected = productMapper.updateClass(classNo, className, startDate, endDate, setTime);

        return Affected > 0;
    }

    public boolean updateProdByClass(String className, int prodPrice, String prodAccount) {

        int Affected = productMapper.updateProdByClass(className, prodPrice, prodAccount);

        return Affected > 0;
    }


    public boolean insertProduct(int prodCategory, String prodName, int prodAmount, int prodPrice, String prodAccount) {

        int Affected = productMapper.insertProduct(prodCategory, prodName, prodAmount, prodPrice, prodAccount);

        return Affected > 0;
    }

    public ProductDTO insertSerial(String prodName) {

        return productMapper.insertSerial(prodName);
    }

    public boolean insertFile(MultipartFile file, ProductDTO product) {

        String uploadPath = IMAGE_DIR;

        File dir = new File(uploadPath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            String originalFileName = file.getOriginalFilename();
            String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
            String savedFileName = UUID.randomUUID() + ext;
            System.out.println("savedFileName = " + savedFileName);

            String filePath = uploadPath + "/" + savedFileName;

            System.out.println("filePath = " + filePath);

            file.transferTo(new File(filePath));

            FileDTO fileDTO = new FileDTO();
            fileDTO.setUploadDate(new Date());
            fileDTO.setFileName(savedFileName);
            fileDTO.setFilePass(filePath);
            fileDTO.setFileSize((int)file.getSize());
            fileDTO.setProdSerial(product.getProdSerial());

            System.out.println("굿");

            productMapper.insertFile(fileDTO);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("반환");

        return true;

    }

}
