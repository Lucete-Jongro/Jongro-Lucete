package com.lucete.comprehensive.product.model.dto;

import java.sql.Time;
import java.util.Date;

public class OneDayClassDTO {

    private int classNo;
    private String className;
    private Date startDate;
    private Date endDate;
    private String teacherName;
    private ProductCategoryDTO prodCategory;
    private Time setTime;
    private ProductDTO productDTO;

    public OneDayClassDTO() {}

    public OneDayClassDTO(int classNo, String className, Date startDate, Date endDate, String teacherName, ProductCategoryDTO prodCategory, Time setTime, ProductDTO productDTO) {
        this.classNo = classNo;
        this.className = className;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherName = teacherName;
        this.prodCategory = prodCategory;
        this.setTime = setTime;
        this.productDTO = productDTO;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public ProductCategoryDTO getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(ProductCategoryDTO prodCategory) {
        this.prodCategory = prodCategory;
    }

    public Time getSetTime() {
        return setTime;
    }

    public void setSetTime(Time setTime) {
        this.setTime = setTime;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "OneDayClassDTO{" +
                "classNo=" + classNo +
                ", className='" + className + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teacherName='" + teacherName + '\'' +
                ", prodCategory=" + prodCategory +
                ", setTime=" + setTime +
                ", productDTO=" + productDTO +
                '}';
    }
}
