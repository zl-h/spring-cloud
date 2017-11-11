package com.shenghe.index.middleware.controller;

import com.alibaba.fastjson.JSONObject;
import com.shenghe.common.entity.HttpResult;
import com.shenghe.index.common.constant.Constant;
import com.shenghe.index.common.entity.Language;
import com.shenghe.index.common.entity.LanguageDict;
import com.shenghe.index.common.util.CookieUtil;
import com.shenghe.index.middleware.service.LanguageDictService;
import com.shenghe.index.middleware.service.LanguageService;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/11/7.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LanguageService languageService;

    @Autowired
    LanguageDictService languageDictService;

    @Value("${spring.application.name}")
    String applicationName;

    /**
     * 登陆初始化
     * @param request
     * @param model
     * @param languageId  如果因为切换语言导致重新下载数据
     * @return
     */
    @RequestMapping("/init")
    public HttpResult init(HttpServletRequest request, HttpServletResponse response,
                           Model model,
                           @RequestParam Map<String,Object> map,
                           @RequestParam(name = "languageId",required = false)Long languageId
    ){
        //不要设置缓存
        List<Language> languageList = languageService.getDataList(null);
        //什么语言
        String userLanguageId =   CookieUtil.getCookieValueByCookieName(request, Constant.COOKIE_LANGUAGE_ID);
        Map<String,Object> myMap = new HashMap<>();
        Long defaultLanguage = null;
        if(languageId != null){
            //什么语言，什么模块
            defaultLanguage = languageId;
        }else if(userLanguageId != null){
            defaultLanguage = Long.valueOf(userLanguageId);
        }else {
            //默认
            defaultLanguage = languageList.get(0).getId();
        }

        //设置用户默认语言
        Cookie defaultLangId = new Cookie(Constant.COOKIE_LANGUAGE_ID,String.valueOf(defaultLanguage));
        defaultLangId.setMaxAge(Integer.MAX_VALUE);
        //设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
        defaultLangId.setPath("/");
        response.addCookie(defaultLangId);

        myMap.put("userLanguageId",defaultLanguage);
        myMap.put("projectName",applicationName);
        List<LanguageDict> languageDictList = languageDictService.getDataList(myMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("languageList",languageList);
        jsonObject.put("languageDictList",languageDictList);
        jsonObject.put("defaultLanguage",String.valueOf(defaultLanguage));
        return HttpResult.getSuccessfulResult(jsonObject);
    }

}