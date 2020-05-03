package cn.edu.sdu.ise.labs.vo;

import lombok.Data;

@Data
public class RangeVO {
    /**
     * 租户代码
     */
    private String tenantCode;

    private String rangeCode;

    private String rangeName;

    private String rangeLocation;

    private Integer status;

    private String closeReason;

    private String description;

    private String createdAt;

    private String updatedAt;

    private String createdBy;

    private String updatedBy;









}
