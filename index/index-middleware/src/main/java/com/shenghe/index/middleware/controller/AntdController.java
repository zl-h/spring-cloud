package com.shenghe.index.middleware.controller;

import com.shenghe.common.entity.HttpResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zl-h on 2017/10/20.
 */
@RestController
public class AntdController {

    /**
     *  某些系统获取列
     * @param databaseName
     * @param databasName
     * @return
     */
    @RequestMapping("/getColumns")
    public HttpResult getColumns(@RequestParam(name = "databaseName",required = true)String databaseName,
                                 @RequestParam(name = "tableName",required = true)String databasName){


        return HttpResult.getSuccessfulResult(null);
    }

}
