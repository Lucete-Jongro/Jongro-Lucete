package com.lucete.comprehensive.product.model.dto;


import com.lucete.comprehensive.common.file.FileDTO;

public class ProductDTO {

    private int prodSerial;
    private String prodName;
    private int prodAmount;
    private int prodPrice;
    private String prodAccount;
    private char prodSoldOut;
    private int prodCategory;
    private int prodView;   // 조회수

    private FileDTO file;
    private ProductCategoryDTO productCategoryDTO;

    public ProductDTO() {}

    public ProductDTO(int prodSerial, String prodName, int prodAmount, int prodPrice, String prodAccount, char prodSoldOut, int prodCategory, int prodView, FileDTO file, ProductCategoryDTO productCategoryDTO) {
        this.prodSerial = prodSerial;
        this.prodName = prodName;
        this.prodAmount = prodAmount;
        this.prodPrice = prodPrice;
        this.prodAccount = prodAccount;
        this.prodSoldOut = prodSoldOut;
        this.prodCategory = prodCategory;
        this.prodView = prodView;
        this.file = file;
        this.productCategoryDTO = productCategoryDTO;
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

    public FileDTO getFile() {
        return file;
    }

    public void setFile(FileDTO file) {
        this.file = file;
    }

    public ProductCategoryDTO getProductCategoryDTO() {
        return productCategoryDTO;
    }

    public void setProductCategoryDTO(ProductCategoryDTO productCategoryDTO) {
        this.productCategoryDTO = productCategoryDTO;
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
                ", file=" + file +
                ", productCategoryDTO=" + productCategoryDTO +
                '}';
    }
}
