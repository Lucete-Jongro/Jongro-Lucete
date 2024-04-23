package com.lucete.comprehensive.product.controller;

import com.lucete.comprehensive.product.model.dto.OneDayClassDTO;
import com.lucete.comprehensive.product.model.dto.ProductDTO;
import com.lucete.comprehensive.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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

        if(isSuccess) {
            // return "원데이클래스 업데이트";
            boolean isFileUpload = productService.classFile(file);

            if (isFileUpload) {
                return "원데이 클래스 업데이트";
            } else {
                return "실패";
            }

        } else {
            return "실패";
        }
    }



}
