package cn.edu.sdu.ise.labs.service.utils;


import cn.edu.sdu.ise.labs.dto.RangeDTO;
import cn.edu.sdu.ise.labs.model.Range;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.RangeVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

/**
 * @author 李洪文
 * @description
 * @date 2019/12/3 9:35
 */
@Data
public class RangeUtils {
    /**
     * 规范并校验rangeDTO
     *
     * @param rangeDTO
     */
    public static void validateRange(RangeDTO rangeDTO) {
        FormatUtils.trimFieldToNull(rangeDTO);
        Assert.notNull(rangeDTO, "场地输入数据不能为空");
        Assert.hasText(rangeDTO.getRangeName(), "场地名称不能为空");
    }

    /**
     * 将实体对象转换为VO对象
     *
     * @param range 实体对象
     * @return VO对象
     */
    public static RangeVO convertToVO(Range range) {
        RangeVO rangeVO = new RangeVO();
        BeanUtils.copyProperties(range, rangeVO);
        rangeVO.setCreatedAt(FormatUtils.formatFullDate(range.getCreatedAt()));
        rangeVO.setUpdatedAt(FormatUtils.formatFullDate(range.getUpdatedAt()));
        return rangeVO;
    }
}








