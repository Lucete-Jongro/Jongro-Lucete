package com.lucete.comprehensive.product.model.dto;


public class ProductDTO {

    private int prodSerial;
    private String prodName;
    private int prodAmount;
    private int prodPrice;
    private String prodAccount;
    private char prodSoldOut;
    private int prodCategory;
    private int prodView;   // 조회수
    private String fileName;    // 파일명
    private String filePass;    // 파일 경로 -> path 오타

    public ProductDTO() {}

    public ProductDTO(int prodSerial, String prodName, int prodAmount, int prodPrice, String prodAccount, char prodSoldOut, int prodCategory, int prodView) {
        this.prodSerial = prodSerial;
        this.prodName = prodName;
        this.prodAmount = prodAmount;
        this.prodPrice = prodPrice;
        this.prodAccount = prodAccount;
        this.prodSoldOut = prodSoldOut;
        this.prodCategory = prodCategory;
        this.prodView = prodView;
    }

    public int getProdSerial() {
        return prodSerial;
    }

    public void setProdSerial(int prodSerial) {
        this.prodSerial = prodSerial;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdAmount() {
        return prodAmount;
    }

    public void setProdAmount(int prodAmount) {
        this.prodAmount = prodAmount;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdAccount() {
        return prodAccount;
    }

    public void setProdAccount(String prodAccount) {
        this.prodAccount = prodAccount;
    }

    public char getProdSoldOut() {
        return prodSoldOut;
    }

    public void setProdSoldOut(char prodSoldOut) {
        this.prodSoldOut = prodSoldOut;
    }

    public int getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(int prodCategory) {
        this.prodCategory = prodCategory;
    }

    public int getProdView() {
        return prodView;
    }

    public void setProdView(int prodView) {
        this.prodView = prodView;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePass() {
        return filePass;
    }

    public void setFilePass(String filePass) {
        this.filePass = filePass;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "prodSerial=" + prodSerial +
                ", prodName='" + prodName + '\'' +
                ", prodAmount=" + prodAmount +
                ", prodPrice=" + prodPrice +
                ", prodAccount='" + prodAccount + '\'' +
                ", prodSoldOut=" + prodSoldOut +
                ", prodCategory=" + prodCategory +
                ", prodView=" + prodView +
                ", fileName='" + fileName + '\'' +
                ", filePass='" + filePass + '\'' +
                '}';
    }
}
