package com.lucete.comprehensive.product.controller;

import com.lucete.comprehensive.product.model.dto.OneDayClassDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import com.lucete.comprehensive.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/onedayclass")
public class OneDayClassController {

    @Autowired
    private ProductService productService;


    // 카테고리 페이지 연결
    @GetMapping("/category")
    public String getCategory() {

        return "/onedayclass/category";
    }

    @GetMapping("/insert")
    public String getInsert() {

        return "/onedayclass/insert";
    }

//    @PostMapping("/insert")
//    @ResponseBody
//    public String insertClass(@RequestParam("className") String className,
//                              @RequestParam("startDate") String startDateStr,
//                              @RequestParam("endDate") String endDateStr,
//                              @RequestParam("setTime") String setTimeStr,
//                              @RequestParam("prodPrice") int prodPrice,
//                              @RequestParam("teacherName") String teacherName,
//                              @RequestParam("prodAccount") String prodAccount) {
//
//        System.out.println("className = " + className);
//        System.out.println("startDate = " + startDateStr);
//        System.out.println("setTimeStr = " + setTimeStr);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        LocalTime localTime = LocalTime.parse(setTimeStr);
//        Time setTime = Time.valueOf(localTime);
//
//        System.out.println("setTime = " + setTime);
//
//        Date startDate;
//        Date endDate;
//
//        try {
//            startDate = dateFormat.parse(startDateStr);
//            System.out.println("startDate = " + startDate);
//            endDate = dateFormat.parse(endDateStr);
//            System.out.println("endDate = " + endDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return "날짜 형식이 올바르지 않음";
//        }
//
//
//        boolean isSuccess = productService.insertClass(className,startDate,endDate,setTime,prodPrice,teacherName,prodAccount);
//
//        if(isSuccess) {
//            return "원데이클래스 업데이트";
//        } else {
//            return "실패";
//        }
//    }

    @PostMapping("/insert")
    @ResponseBody
    public String insertClass(@RequestParam("className") String className,
                              @RequestParam("startDate") String startDateStr,
                              @RequestParam("endDate") String endDateStr,
                              @RequestParam("setTime") String setTimeStr,
                              @RequestParam("prodPrice") int prodPrice,
                              @RequestParam("teacherName") String teacherName,
                              @RequestParam("prodAccount") String prodAccount,
                              @RequestParam("fileName")MultipartFile file) {

        System.out.println("className = " + className);
        System.out.println("startDate = " + startDateStr);
        System.out.println("setTimeStr = " + setTimeStr);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalTime localTime = LocalTime.parse(setTimeStr);
        Time setTime = Time.valueOf(localTime);

        System.out.println("setTime = " + setTime);

        Date startDate;
        Date endDate;

        try {
            startDate = dateFormat.parse(startDateStr);
            System.out.println("startDate = " + startDate);
            endDate = dateFormat.parse(endDateStr);
            System.out.println("endDate = " + endDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "날짜 형식이 올바르지 않음";
        }


        boolean isSuccess = productService.insertClass(className,startDate,endDate,setTime,prodPrice,teacherName,prodAccount);

        if( isSuccess) {
            // return "원데이클래스 업데이트";
            System.out.println("service 넘어감");

            ProductDTO product = productService.getSerial(className);
            if (product == null) {
                System.out.println("해당상품 존재 x");
                throw new RuntimeException("해당 상품 존재 x");
            }

            boolean isFileUpload = productService.classFile(file, product);

            if (isFileUpload) {
                return "원데이 클래스 업데이트";
            } else {
                return "실패";
            }

        } else {
            return "실패";
        }
    }

    @GetMapping("/list")
    public String getList(Model model) {

        List<ProductDTO> productList = productService.getList();
        model.addAttribute("products", productList);

        return "onedayclass/list";
    }


    @GetMapping("/modify")
    public String categorySelect(Model model) {
        List<OneDayClassDTO> onedayclassList = productService.findClass();
        model.addAttribute("classList", onedayclassList);

        return "onedayclass/modify";
    }

    @GetMapping("/information")
    @ResponseBody
    public Map<String, Object> selectByClassNo(@RequestParam(value = "classNo", required = false)Integer classNo ) {

        System.out.println("classNo " + classNo);

        OneDayClassDTO oneDayClass = productService.selectByClassNo(classNo);
        ProductDTO product = productService.prodByClass(oneDayClass);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedStartDate = dateFormat.format(oneDayClass.getStartDate());
        String formattedEndDate = dateFormat.format(oneDayClass.getEndDate());
        String formattedSetTime = String.valueOf(oneDayClass.getSetTime());

        Map<String, Object> response = new HashMap<>();
        response.put("startDate", formattedStartDate);
        response.put("endDate", formattedEndDate);
        response.put("className", oneDayClass.getClassName());
        response.put("timeSet", formattedSetTime);
        response.put("prodPrice", product.getProdPrice());
        response.put("prodAccount", product.getProdAccount());
        System.out.println(formattedSetTime);

        System.out.println("ajax 복귀");
        return response;
    }


    @PostMapping("/update")
    @ResponseBody
    @Transactional
    public String updateClass(@RequestParam("className") String className,
                              @RequestParam("startDate") String startDateStr,
                              @RequestParam("endDate") String endDateStr,
                              @RequestParam("timeSet") String setTimeStr,
                              @RequestParam("prodPrice") int prodPrice,
                              @RequestParam("prodAccount") String prodAccount,
                              @RequestParam("classNo") String classNo) {


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalTime localTime = LocalTime.parse(setTimeStr);
        Time setTime = Time.valueOf(localTime);

        System.out.println("setTime = " + setTime);

        Date startDate;
        Date endDate;

        try {
            startDate = dateFormat.parse(startDateStr);
            System.out.println("startDate = " + startDate);
            endDate = dateFormat.parse(endDateStr);
            System.out.println("endDate = " + endDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "날짜 형식이 올바르지 않음";
        }


        boolean isSuccess = productService.updateClass(classNo,className, startDate, endDate, setTime);

        if (isSuccess) {
            boolean isSuccessProd = productService.updateProdByClass(className, prodPrice, prodAccount);

            if (isSuccessProd) {

                return "클래스 업데이트";

            } else {

                return "실패";
            }

        } else {

            return "실패";
        }

    }



}
