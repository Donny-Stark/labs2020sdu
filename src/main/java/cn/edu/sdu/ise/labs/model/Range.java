package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.Date;

@Data
public class Range {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 场地代码
     */
    private String rangeCode;

    /**
     * 场地名称
     */
    public String rangeName;

    /**
     * 场地地址
     */
    private String rangeLocation;

    /**
     * 场地状态
     */
    private Integer status;

    /**
     * 关闭原因
     */
    private String closeReason;

    /**
     * 备注
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 删除标记
     */
    private Boolean deleted;

    /**
     * 租户代码
     */
    private String tenantCode;
}