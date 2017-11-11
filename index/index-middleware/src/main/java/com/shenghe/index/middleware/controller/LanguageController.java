package com.shenghe.index.middleware.controller;

import com.shenghe.common.entity.HttpResult;
import com.shenghe.index.common.antdEntity.AntdColumn;
import com.shenghe.index.common.antdEntity.AntdResult;
import com.shenghe.index.common.constant.Constant;
import com.shenghe.index.common.entity.Language;
import com.shenghe.index.common.util.CookieUtil;
import com.shenghe.index.middleware.constant.IndexConstant;
import com.shenghe.index.middleware.service.ColumnService;
import com.shenghe.index.middleware.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/10/23.
 * 语言管理控制器
 */
@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    ColumnService columnService;

    @Autowired
    LanguageService languageService;

    @RequestMapping("/getTableData")
    public HttpResult getTableData(HttpServletRequest request,
                                   @RequestParam(name = "id",required = false) Long id,
                                   @RequestParam(name = "userLanguage",required = false) String userLanguage,
                                   @RequestParam(name = "current",required = false) Long current,
                                   @RequestParam(name = "pageSize",required = false) Long pageSize,
                                   @RequestParam Map<String,Object> map){
        String languageId = CookieUtil.getCookieValueByCookieName(request,Constant.COOKIE_LANGUAGE_ID);
        Long langId = null;
        if(languageId != null)langId = Long.valueOf(languageId);
        List<AntdColumn> columnList = columnService.getColumns(IndexConstant.systemName,IndexConstant.languageodualName,langId);

        if(current != null && pageSize != null){
            map.put("current",(current - 1)*pageSize);
            map.put("pageSize",pageSize);
        }

        List<Language> languageList = languageService.getDataList(map);
        Long count = languageService.getDataListCount(map);
        AntdResult antdResult = AntdResult.getAntdResult(languageList,count,columnList,null);
        return HttpResult.getSuccessfulResult(antdResult);
    }


    /**
     * 语言查询
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getData")
    public HttpResult getData(HttpServletRequest request, Model model,
                                  @RequestParam Map<String,Object> map
    ){
        //不要设置缓存
        List<Language> languageList = languageService.getDataList(map);
        Long count = languageService.getDataListCount(map);
        return HttpResult.getDataList(count,languageList);
    }

    /**
     * 数据修改接口
     * @param request
     * @return
     */
    @RequestMapping("/setData")
    public HttpResult setData(HttpServletRequest request,
                              @RequestParam Long id,
                              @RequestParam String userLanguage,
                              @RequestParam String remark,
                              @RequestParam Map<String,Object> map
    ){
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("id",id);
        objectMap.put("userLanguage",userLanguage);
        objectMap.put("remark",remark);
        Integer count = languageService.setData(objectMap);
        return HttpResult.getSuccessfulResult(null);
    }

    @RequestMapping("/removeData")
    public HttpResult removeData(HttpServletRequest request, Model model,
                                 @RequestParam(name = "id",required = false) Long id,
                                 @RequestParam(name = "ids",required = false) List<Long> ids
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("ids",ids);
        //必须传
        if(id == null && ids == null){
            return HttpResult.getErrorMessage("id或ids必传一个",null);
        }
        Integer count = languageService.removeData(map);
        return HttpResult.getSuccessfulResult(null);
    }


    @RequestMapping("/addData")
    public HttpResult addData(HttpServletRequest request, Model model,
                              @RequestParam(name ="userLanguage",required = false) String userLanguage,
                              @RequestParam (name ="remark",required = false)String remark
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("userLanguage",userLanguage);
        map.put("remark",remark);
        Integer count = languageService.addData(map);
        //根据菜单具体业务模块，传相应的参数即可
        return HttpResult.getSuccessfulResult(null);
    }

}
