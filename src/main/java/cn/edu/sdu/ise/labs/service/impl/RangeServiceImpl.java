package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.constant.PrefixConstant;
import cn.edu.sdu.ise.labs.dao.RangeMapper;
import cn.edu.sdu.ise.labs.dto.RangeDTO;
import cn.edu.sdu.ise.labs.dto.RangeQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.model.Range;
import cn.edu.sdu.ise.labs.model.Token;
import cn.edu.sdu.ise.labs.service.KeyMaxValueService;
import cn.edu.sdu.ise.labs.service.RangeService;
import cn.edu.sdu.ise.labs.service.utils.RangeUtils;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.utils.PageUtils;
import cn.edu.sdu.ise.labs.utils.TokenContextHolder;
import cn.edu.sdu.ise.labs.vo.RangeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author 李洪文
 * @description
 * @date 2019/12/3 9:33
 */
@Service
public class RangeServiceImpl implements RangeService {
    @Autowired
    private RangeMapper rangeMapper;

    @Autowired
    private KeyMaxValueService keyMaxValueService;

    @Override
    public Page<RangeVO> listByPage(RangeQueryDTO queryDTO) {
        if (queryDTO == null) {
            queryDTO = new RangeQueryDTO();
        }

        queryDTO.setRangeCode(FormatUtils.makeFuzzySearchTerm(queryDTO.getRangeCode()));
        Token token = TokenContextHolder.getToken();

        Integer size = rangeMapper.count(queryDTO, token.getTenantCode());
        PageUtils pageUtils = new PageUtils(queryDTO.getPage(), queryDTO.getPageSize(), size);
        Page<RangeVO> pageData = new Page<>(pageUtils.getPage(), pageUtils.getPageSize(), pageUtils.getTotal(), new ArrayList<>());
        if (size == 0) {
            // 没有命中，则返回空数据。
            return pageData;
        }

        List<Range> list = rangeMapper.list(queryDTO, pageUtils.getOffset(), pageUtils.getLimit(), token.getTenantCode());
        for (Range range : list) {
            pageData.getList().add(RangeUtils.convertToVO(range));
        }

        return pageData;
    }


    /**
     * 新建部门
     *
     * @param rangeDTO 部门输入对象
     * @return 部门编码
     */
    @Override
    public String addRange(RangeDTO rangeDTO) {
        // 校验输入数据正确性
        RangeUtils.validateRange(rangeDTO);
        // 创建实体对象，用以保存到数据库
        Token token = TokenContextHolder.getToken();
        //查询是否存在场地项目
        Assert.hasText(rangeDTO.getRangeName(), "场地名称不能为空");
        Range range0 = rangeMapper.getByName(rangeDTO.getRangeName(),token.getTenantCode());
        Assert.isNull(range0,"已存在场地项目:" + rangeDTO.getRangeName());
        Range range = new Range();
        // 将输入的字段全部复制到实体对象中
        BeanUtils.copyProperties(rangeDTO,range);
        // 生成业务代码
        range.setRangeCode(keyMaxValueService.generateBusinessCode(PrefixConstant.RANGE));
        // 将token相关信息填入range对象
        TokenContextHolder.formatInsert(range);
        // 调用DAO方法保存到数据库表
        rangeMapper.insert(range);
        return range.getRangeCode();
    }

    /**
     * 更新部门数据
     *
     * @param rangeDTO 部门输入对象
     * @return 部门编码
     */
    @Override
    public String updateRange(RangeDTO rangeDTO) {
        // 校验输入数据正确性
        Token token = TokenContextHolder.getToken();
        RangeUtils.validateRange(rangeDTO);
        //检测输入信息
        Assert.hasText(rangeDTO.getRangeCode(), "场地代码不能为空");
        Range range = rangeMapper.getByCode(rangeDTO.getRangeCode(),token.getTenantCode());
        Assert.notNull(range, "未找到场地，代码为：" + rangeDTO.getRangeCode());

        //查询是否存在场地项目
          Range range1 = rangeMapper.getByName(rangeDTO.getRangeName(),token.getTenantCode());

          if(!range.rangeName.equals(rangeDTO.rangeName)){
              Assert.isNull(range1,"已存在场地项目:" + rangeDTO.getRangeName());
          }

        BeanUtils.copyProperties(rangeDTO,range);
        range.setUpdatedBy(token.getTenantCode());
        rangeMapper.updateByPrimaryKey(range);
        return range.getRangeCode();


    }

    /**
     * 根据编码列表，批量删除部门
     *
     * @param codeList 编码列表
     */
    @Override
    public void deleteByCodes(List<String> codeList) {
        Assert.notEmpty(codeList, "部门编码列表不能为空");
        Token token = TokenContextHolder.getToken();
        rangeMapper.deleteByCodes(codeList, token.getTeacherCode(), token.getTenantCode());
    }

    /**
     * 根据编码列表，获取部门集合（内部调用）
     *
     * @param codeList 部门编码列表
     * @return 包含部门信息的映射，key是部门编码
     */
    @Override
    public Map<String, RangeVO> getRangeMap(List<String> codeList) {
        if (CollectionUtils.isEmpty(codeList)) {
            return new HashMap<>(1 << 2);
        }

        Token token = TokenContextHolder.getToken();
        List<Range> rangeList = rangeMapper.listByCodes(codeList, token.getTenantCode());
        return rangeList.stream()
                .map(item -> RangeUtils.convertToVO(item))
                .collect(Collectors.toMap(RangeVO::getRangeCode, Function.identity()));
    }

    /**
     * 根据部门名称获取下拉列表
     *
     * @param rangeCode 部门名称（模糊匹配）
     * @return 部门列表
     */
    @Override
    public List<RangeVO> listByCode(String rangeCode) {
        Token token = TokenContextHolder.getToken();
        rangeCode = FormatUtils.makeFuzzySearchTerm(rangeCode);
        List<Range> rangeList = rangeMapper.listByCode(rangeCode, token.getTenantCode());
        return rangeList.stream()
                .map(item ->
                        RangeUtils.convertToVO(item))
                .collect(Collectors.toList());
    }

    @Override
    public List<RangeVO> getrange(String rangeCode) {
        return null;
    }
}
