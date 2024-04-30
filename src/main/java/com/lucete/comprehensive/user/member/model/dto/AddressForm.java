package com.lucete.comprehensive.user.member.model.dto;

public class AddressForm {
    private String postcode;
    private String address;
    private String detailAddress;
    private String extraAddress;

    // 생성자, 게터, 세터 등 필요한 메서드를 추가할 수 있음

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getExtraAddress() {
        return extraAddress;
    }

    public void setExtraAddress(String extraAddress) {
        this.extraAddress = extraAddress;
    }
}