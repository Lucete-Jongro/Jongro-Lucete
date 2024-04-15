package com.lucete.comprehensive.board.inquiry.dto;


public class InquiryCategoryDTO {
    /* 게시판 카테고리 분류 */
    private String nomal;          //일반
    private String product;        //상품
    private String diyProduct;    //diy 자재
    private String onedayClass;   //원데이클래스
    private String event;         //이벤트

    public InquiryCategoryDTO() {
    }

    public InquiryCategoryDTO(String nomal, String product, String diyProduct, String onedayClass, String event) {
        this.nomal = nomal;
        this.product = product;
        this.diyProduct = diyProduct;
        this.onedayClass = onedayClass;
        this.event = event;
    }

    public String getNomal() {
        return nomal;
    }

    public void setNomal(String nomal) {
        this.nomal = nomal;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDiyProduct() {
        return diyProduct;
    }

    public void setDiyProduct(String diyProduct) {
        this.diyProduct = diyProduct;
    }

    public String getOnedayClass() {
        return onedayClass;
    }

    public void setOnedayClass(String onedayClass) {
        this.onedayClass = onedayClass;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "InquiryCategoryDTO{" +
                "nomal='" + nomal + '\'' +
                ", product='" + product + '\'' +
                ", diyProduct='" + diyProduct + '\'' +
                ", onedayClass='" + onedayClass + '\'' +
                ", event='" + event + '\'' +
                '}';
    }
}
