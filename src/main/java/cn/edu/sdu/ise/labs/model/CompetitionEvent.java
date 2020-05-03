package cn.edu.sdu.ise.labs.model;

import java.util.Date;

public class CompetitionEvent {
    private Integer id;

    private String tenantCode;

    private String competitionEventCode;

    private String competitionEventName;

    private Integer suiteType;

    private Date planStartAt;

    private Date planEndAt;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode == null ? null : tenantCode.trim();
    }

    public String getCompetitionEventCode() {
        return competitionEventCode;
    }

    public void setCompetitionEventCode(String competitionEventCode) {
        this.competitionEventCode = competitionEventCode == null ? null : competitionEventCode.trim();
    }

    public String getCompetitionEventName() {
        return competitionEventName;
    }

    public void setCompetitionEventName(String competitionEventName) {
        this.competitionEventName = competitionEventName == null ? null : competitionEventName.trim();
    }

    public Integer getSuiteType() {
        return suiteType;
    }

    public void setSuiteType(Integer suiteType) {
        this.suiteType = suiteType;
    }

    public Date getPlanStartAt() {
        return planStartAt;
    }

    public void setPlanStartAt(Date planStartAt) {
        this.planStartAt = planStartAt;
    }

    public Date getPlanEndAt() {
        return planEndAt;
    }

    public void setPlanEndAt(Date planEndAt) {
        this.planEndAt = planEndAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }
}