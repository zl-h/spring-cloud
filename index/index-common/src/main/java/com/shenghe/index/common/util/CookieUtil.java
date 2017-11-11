package com.shenghe.index.common.util;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zl-h on 2017/10/14.
 */
public class CookieUtil {

    public static String getCookieValueByCookieName(HttpServletRequest request,String cookieName){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return null;
        }
        for(int i = 0;i < cookies.length;i ++){
            if(cookies[i].getName().equals(cookieName)){
                return cookies[i].getValue();
            }
        }
        return null;
    }

}
