package com.shenghe.index.middleware.controller;

import com.shenghe.common.entity.HttpResult;
import com.shenghe.index.common.antdEntity.AntdColumn;
import com.shenghe.index.middleware.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zl-h on 2017/10/22.
 */
@RestController
@RequestMapping("/column")
public class ColumnController {

    @Autowired
    ColumnService columnService;
    //获取列
    @RequestMapping("/getColumns")
    public HttpResult getColumns(@RequestParam(name = "systemName",required = false)String systemName,
                                 @RequestParam(name = "modualName",required = false)String modualName,
                                 @RequestParam(name = "languageId",required = false)Long languageId
    ){
        List<AntdColumn> columnList = columnService.getColumns(systemName, modualName, languageId);
        return HttpResult.getSuccessfulResult(columnList);
    }

}
