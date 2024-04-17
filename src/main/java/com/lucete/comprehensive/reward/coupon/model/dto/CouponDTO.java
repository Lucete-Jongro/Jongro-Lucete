package com.lucete.comprehensive.reward.coupon.model.dto;

import java.time.LocalDateTime;

public class CouponDTO {
    private int couponNo;
    private String couponName;
    private String couponType;
    private String coiponTargetGroup;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime validityPeriod;
    private int memNo;

    public CouponDTO() {
    }

    public CouponDTO(int couponNo, String couponName, String couponType,
                     String coiponTargetGroup, LocalDateTime startDate,
                     LocalDateTime endDate, LocalDateTime validityPeriod, int memNo) {
        this.couponNo = couponNo;
        this.couponName = couponName;
        this.couponType = couponType;
        this.coiponTargetGroup = coiponTargetGroup;
        this.startDate = startDate;
        this.endDate = endDate;
        this.validityPeriod = validityPeriod;
        this.memNo = memNo;
    }
}
