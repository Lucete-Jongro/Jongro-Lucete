package com.lucete.comprehensive.reward.point.model.dto;

import java.time.LocalDateTime;

public class PointDTO {
    private int pointNo;
    private String pointGrantReason;
    private int pointGrantPoint;
    private LocalDateTime pointGrantDate;
    private int memNo;

    public PointDTO() {
    }

    public PointDTO(int pointNo, String pointGrantReason,
                    int pointGrantPoint, LocalDateTime pointGrantDate,
                    int memNo) {
        this.pointNo = pointNo;
        this.pointGrantReason = pointGrantReason;
        this.pointGrantPoint = pointGrantPoint;
        this.pointGrantDate = pointGrantDate;
        this.memNo = memNo;
    }

    public int getPointNo() {
        return pointNo;
    }

    public void setPointNo(int pointNo) {
        this.pointNo = pointNo;
    }

    public String getPointGrantReason() {
        return pointGrantReason;
    }

    public void setPointGrantReason(String pointGrantReason) {
        this.pointGrantReason = pointGrantReason;
    }

    public int getPointGrantPoint() {
        return pointGrantPoint;
    }

    public void setPointGrantPoint(int pointGrantPoint) {
        this.pointGrantPoint = pointGrantPoint;
    }

    public LocalDateTime getPointGrantDate() {
        return pointGrantDate;
    }

    public void setPointGrantDate(LocalDateTime pointGrantDate) {
        this.pointGrantDate = pointGrantDate;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    @Override
    public String toString() {
        return "PointDTO{" +
                "pointNo=" + pointNo +
                ", pointGrantReason='" + pointGrantReason + '\'' +
                ", pointGrantPoint=" + pointGrantPoint +
                ", pointGrantDate=" + pointGrantDate +
                ", memNo=" + memNo +
                '}';
    }
}
