package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.dto.RangeDTO;
import cn.edu.sdu.ise.labs.dto.RangeQueryDTO;
import cn.edu.sdu.ise.labs.model.ResultContext;
import cn.edu.sdu.ise.labs.service.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理后端服务模块
 *
 * @author 李洪文
 * @description
 * @date 2019/12/3 11:07
 */

@RestController
@RequestMapping("range")
public class RangeController {
    @Autowired
    private RangeService rangeService;

    @PostMapping("add")
    public ResultContext add(@RequestBody RangeDTO rangeDTO) {
        return ResultContext.returnSuccess(rangeService.addRange(rangeDTO));
    }

    @PostMapping("update")
    public ResultContext update(@RequestBody RangeDTO rangeDTO) {
        return ResultContext.returnSuccess(rangeService.updateRange(rangeDTO));
    }

    @PostMapping("list")
    public ResultContext list(@RequestBody RangeQueryDTO queryDTO) {
        return ResultContext.returnSuccess(rangeService.listByPage(queryDTO));
    }

    @GetMapping("listByCode")
    public ResultContext listByCode(String rangeCode) {
        return ResultContext.returnSuccess(rangeService.listByCode(rangeCode));
    }

    @PostMapping("delete")
    public ResultContext delete(@RequestBody List<String> codeList) {
        rangeService.deleteByCodes(codeList);
        return ResultContext.returnSuccess(true);
    }
}

