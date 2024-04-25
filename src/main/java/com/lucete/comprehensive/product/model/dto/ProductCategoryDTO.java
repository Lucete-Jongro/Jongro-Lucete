package com.lucete.comprehensive.product.model.dto;

public class ProductCategoryDTO {

    private int prodCategory;
    private String categoryName;
    private int refCategoryCode;

    private ProductDTO productDTO;

    public ProductCategoryDTO() {}

    public ProductCategoryDTO(int prodCategory, String categoryName, int refCategoryCode, ProductDTO productDTO) {
        this.prodCategory = prodCategory;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.productDTO = productDTO;
    }

    public int getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(int prodCategory) {
        this.prodCategory = prodCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(int refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "ProductCategoryDTO{" +
                "prodCategory=" + prodCategory +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", productDTO=" + productDTO +
                '}';
    }
}
