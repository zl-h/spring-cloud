package com.shenghe.index.server.controller;

import com.shenghe.common.entity.HttpResult;
import com.shenghe.index.common.constant.Constant;
import com.shenghe.index.common.entity.User;
import com.shenghe.index.common.util.CookieUtil;
import com.shenghe.index.server.service.TokenService;
import com.shenghe.index.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/10/11.
 */
@RestController
@RequestMapping("/log")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param defaultLang
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public HttpResult doLogin(@RequestParam(name = "user_name") String userName,
                              @RequestParam(name = "password")String password,
                              @RequestParam(name = "default_lang",required = false)Long defaultLang,
                              HttpServletRequest request,
                              HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        List<User> userList = userService.getDataList(map);
        if(userList.size() > 0){
            if(userList.get(0).getPassword().equals(password)){
                /*request.getSession().setAttribute(Constant.sessionUser,userList.get(0));*/
                /*userService.saveSession(request.getSession());*/
                //设置token
                String tokenId = tokenService.getToken(userList.get(0));
                Cookie cookie = new Cookie(Constant.TOKEN_ID,tokenId);
                cookie.setMaxAge(Integer.MAX_VALUE);
                //设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
                cookie.setPath("/");
                response.addCookie(cookie);

                //设置userId
                Cookie userIdCookie = new Cookie(Constant.COOKIE_USER_ID,String.valueOf(userList.get(0).getId()));
                userIdCookie.setMaxAge(Integer.MAX_VALUE);
                //设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
                userIdCookie.setPath("/");
                response.addCookie(userIdCookie);

                //设置用户名
                Cookie userNameCookie = new Cookie(Constant.COOKIE_USER_NAME,String.valueOf(userList.get(0).getUserName()));
                userNameCookie.setMaxAge(Integer.MAX_VALUE);
                //设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
                userNameCookie.setPath("/");
                response.addCookie(userNameCookie);

                //设置用户默认语言
                Cookie defaultLangId = new Cookie(Constant.COOKIE_LANGUAGE_ID,String.valueOf(defaultLang));
                defaultLangId.setMaxAge(Integer.MAX_VALUE);
                //设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
                defaultLangId.setPath("/");
                response.addCookie(defaultLangId);

                //更新用户状态
                Map<String,Object> setMap = new HashMap<>();
                setMap.put("id",userList.get(0).getId());
                setMap.put("defaultLangId",defaultLang);
                userService.setData(setMap);

                return HttpResult.getSuccessfulResult(tokenId);
            }else {
                return HttpResult.newInstance(-1,"密码错误",null);
            }
        }else {
            return HttpResult.newInstance(-2,"用户名不存在",null);
        }
    }

    /**
     * token校验
     * @param request
     * @return
     */
    @RequestMapping("/checkToken")
    public HttpResult checkToken(HttpServletRequest request,
                                 @RequestParam(name = "url_path",required = false)String urlPath){
        String token = CookieUtil.getCookieValueByCookieName(request,Constant.TOKEN_ID);
        boolean flag = tokenService.validToken(token);
        if(flag == true)return HttpResult.getSuccessfulResult(null);
        else return HttpResult.getFailureResult(null);
    }

}