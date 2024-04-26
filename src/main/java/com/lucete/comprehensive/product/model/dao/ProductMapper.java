package com.lucete.comprehensive.product.model.dao;

import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.common.paging.SelectCriteria;
import com.lucete.comprehensive.product.model.dto.OneDayClassDTO;
import com.lucete.comprehensive.product.model.dto.ProductCategoryDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {


    int selectTotalCount(Map<String, String> searchMap);

    List<ProductDTO> selectProductList(SelectCriteria selectCriteria);

    List<ProductCategoryDTO> findCategory();

    List<ProductDTO> findProductList();

    ProductDTO selectBySerial(Integer prodSerial);

    int updateProduct(String prodSerial, String prodName, int prodAmount, int prodPrice, String prodAccount);


    int insertClass(String className, Date startDate, Date endDate, Time setTime, String teacherName);

    int classProduct(int prodPrice, String prodAccount, String className);

    void classFile(FileDTO fileDTO);

    ProductDTO getSerial(String className);

    List<ProductDTO> getList();

    List<OneDayClassDTO> findClass();

    OneDayClassDTO selectByClassNo(Integer classNo);

    ProductDTO prodByClass(OneDayClassDTO oneDayClass);

    int updateClass(String classNo, String className, Date startDate, Date endDate, Time setTime);

    int updateProdByClass(String className, int prodPrice, String prodAccount);

    int insertProduct(int prodCategory, String prodName, int prodAmount, int prodPrice, String prodAccount);

    ProductDTO insertSerial(String prodName);

    void insertFile(FileDTO fileDTO);
}
