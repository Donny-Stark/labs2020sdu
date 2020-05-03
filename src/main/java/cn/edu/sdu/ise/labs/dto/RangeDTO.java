package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

/**
 * @author 李洪文
 * @description
 * @date 2019/12/3 9:20
 */
@Data

public class RangeDTO {

    /**
     * 新建场地DTO
     */

    /**
     * 场地编码
     */
    public String rangeName;

   /**
    * 场地位置
    */
    private  String rangeLocation;

    /**
     * 状态编码
     */
    private  Integer status;

    /**
     * 关闭原因
     */
    private  String closeReason;

    /**
     *备注
     */
    private  String description;


    /**
     *
     * 修改场地(除过rangeCode其余和新建一样)
     */

    /**
     * 场地编码
     */
    private  String rangeCode;





}
