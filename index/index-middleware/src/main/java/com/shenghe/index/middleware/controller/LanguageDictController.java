package com.shenghe.index.middleware.controller;

import com.shenghe.common.entity.HttpResult;
import com.shenghe.index.common.constant.Constant;
import com.shenghe.index.common.entity.LanguageDict;
import com.shenghe.index.common.util.CookieUtil;
import com.shenghe.index.middleware.service.LanguageDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/7/7.
 */
@Controller
@RequestMapping("/languageDict")
public class LanguageDictController {

    @Value("${spring.application.name}")
    String applicationName;

    @Autowired
    LanguageDictService languageDictService;

    //得到首页怨言字典数据（登陆，菜单展示）
    @RequestMapping("/getIndexDict")
    @ResponseBody
    public HttpResult getIndexDict(HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        map.put("projectName",applicationName);
        String userLanguageId =   CookieUtil.getCookieValueByCookieName(request, Constant.COOKIE_LANGUAGE_ID);
        if(userLanguageId != null){
            map.put("userLanguageId",Long.valueOf(userLanguageId));
        }
        List<LanguageDict> languageDictList = languageDictService.getDataList(map);
        return HttpResult.getSuccessfulResult(languageDictList);
    }

}
