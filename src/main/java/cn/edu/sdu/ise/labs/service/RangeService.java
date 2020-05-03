package cn.edu.sdu.ise.labs.service;


import cn.edu.sdu.ise.labs.dto.RangeDTO;
import cn.edu.sdu.ise.labs.dto.RangeQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.vo.RangeVO;

import java.util.List;
import java.util.Map;

public interface RangeService {
    Page<RangeVO> listByPage(RangeQueryDTO queryDTO);

    /**
     * 新建场地
     * @param rangeDTO
     * @return 场地编码
     */
    String addRange(RangeDTO rangeDTO);

    /**
     * 根据编码列表，批量删除部门
     *
     * @param codeList 编码列表
     */
    void deleteByCodes(List<String> codeList);

    /**
     *
     * 更新
     * @param rangeDTO
     * @return
     */
    String updateRange(RangeDTO rangeDTO);

    /**
     * 根据编码列表，获取部门集合（内部调用）
     *
     * @param codeList 部门编码列表
     * @return 包含部门信息的映射，key是部门编码
     */
    Map<String, RangeVO> getRangeMap(List<String> codeList);


    List<RangeVO> getrange(String rangeCode);

    /**
     * 根据部门名称获取下拉列表
     *
     * @param rangeCode 部门名称（模糊匹配）
     * @return 部门列表
     */
    List<RangeVO> listByCode(String rangeCode);


}
