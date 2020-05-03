package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class RangeQueryDTO {

    private String rangeCode;

    private String rangeName;

    private String rangeLocation;

    private Number status;


    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页记录数
     */
    private Integer pageSize;

}

