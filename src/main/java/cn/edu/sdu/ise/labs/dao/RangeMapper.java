package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.dto.RangeQueryDTO;
import cn.edu.sdu.ise.labs.model.Range;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 场地数据访问组件
 *
 * @author 李硕
 * @date 2020/03/14 10:38
 */

public interface RangeMapper {

    /**
     * 新增记录
     *
     * @param record
     * @return
     */
    int insert(Range record);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);



    /**
     * 根据主键选择
     *
     * @param id
     * @return
     */
    Range selectByPrimaryKey(Integer id);


    /**
     * 根据主键更新记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Range record);





    /**
     * 根据查询条件获取场地列表
     *
     * @param queryDTO   查询条件
     * @param offset     开始位置
     * @param limit      记录数量
     * @param tenantCode 租户代码
     * @return 场地列表
     */
    List<Range> list(
            @Param("queryDTO") RangeQueryDTO queryDTO,
            @Param("offset") Integer offset,
            @Param("limit") Integer limit,
            @Param("tenantCode") String tenantCode);


    /**
     * 根据查询条件获取命中个数
     *
     * @param queryDTO   查询条件
     * @param tenantCode 场地代码
     * @return 命中数量
     */
    Integer count(
            @Param("queryDTO") RangeQueryDTO queryDTO,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据代码列表批量删除部门
     *
     * @param codeList    代码列表
     * @param teacherCode 操作人
     * @param tenantCode  租户代码
     */
    void deleteByCodes(
            @Param("codeList") List<String> codeList,
            @Param("teacherCode") String teacherCode,
            @Param("tenantCode") String tenantCode);




    List<Range> listByCodes(
            @Param("codeList") List<String> codeList,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据部门名称查询部门列表
     *
     * @param rangeCode 部门名称，模糊匹配
     * @param tenantCode     租户代码
     * @return 部门列表
     */
    List<Range> listByCode(
            @Param("rangeCode") String rangeCode,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据部门编码获取部门信息详情
     *
     * @param rangeCode 部门编码
     * @param tenantCode     租户代码
     * @return 门信息详情
     */
    Range getByCode(
            @Param("rangeCode") String rangeCode,
            @Param("tenantCode") String tenantCode);

    /**
     *
     * @param queryDTO 
     * @param tenantCode
     * @return
     */
    Range getByName(
            @Param("rangeName") String rangeName,
            @Param("tenantCode") String tenantCode);





}