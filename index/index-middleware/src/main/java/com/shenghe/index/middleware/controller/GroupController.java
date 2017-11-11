package com.shenghe.index.middleware.controller;

import com.alibaba.fastjson.JSONObject;
import com.shenghe.common.entity.HttpResult;
import com.shenghe.index.common.antdEntity.AntdColumn;
import com.shenghe.index.common.antdEntity.AntdResult;
import com.shenghe.index.common.constant.Constant;
import com.shenghe.index.common.entity.Group;
import com.shenghe.index.common.entity.Menu;
import com.shenghe.index.common.entity.User;
import com.shenghe.index.common.util.CookieUtil;
import com.shenghe.index.common.util.StringUtil;
import com.shenghe.index.middleware.constant.IndexConstant;
import com.shenghe.index.middleware.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/10/20.
 */
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    ColumnService columnService;

    @Autowired
    GroupService groupService;

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @Autowired
    AuthorityMenuGroupService authorityMenuGroupService;

    @Autowired
    AuthorityUserGroupService authorityUserGroupService;

    @RequestMapping("/getTableData")
    public HttpResult getTableData(HttpServletRequest request, @RequestParam Map<String,Object> map){
        String languageId = CookieUtil.getCookieValueByCookieName(request, Constant.COOKIE_LANGUAGE_ID);
        Long langId = null;
        if(languageId != null)langId = Long.valueOf(languageId);
        List<AntdColumn> columnList = columnService.getColumns(IndexConstant.systemName,IndexConstant.userModualName,langId);
        List<Group> languageList = groupService.getDataList(map);
        Long count = groupService.getDataListCount(map);
        //求出所有用户和菜单
        List<User> userList = userService.getDataList(null);
        List<Menu> menuList = menuService.getDataList(null);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userList",userList);
        jsonObject.put("menuList",menuList);

        AntdResult antdResult = AntdResult.getAntdResult(languageList,count,columnList,jsonObject);
        return HttpResult.getSuccessfulResult(antdResult);
    }


    /**
     * 语言查询
     * @param request
     * @param model
     * @return
     *//*
    @RequestMapping("/getData")
    public HttpResult getData(HttpServletRequest request, Model model,
                              @RequestParam Map<String,Object> map
    ){
        //不要设置缓存
        List<Language> languageList = userService.getDataList(map);
        Integer count = userService.getDataListCount(map);
        return HttpResult.getDataList(count,languageList);
    }*/

    /**
     * 数据修改接口
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/setData")
    public HttpResult setData(HttpServletRequest request, Model model,
                              @RequestParam Long id,
                              @RequestParam String groupName,
                              @RequestParam String remark,
                              @RequestParam(required = false,defaultValue = ",") String showUsers,
                              @RequestParam(required = false,defaultValue = ",") String showMenus
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("groupName",groupName);

        String[] showUsersArray = showUsers.split(",");
        if(showUsersArray.length != 0){
            List<Long> idList = StringUtil.stringArrayToLongList(showUsersArray);
            Map<String,Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("idList",idList);
            List<User> userList = userService.getDataList(stringObjectMap);
            String userString = userService.userListToString(userList);
            map.put("showUsers",userString);
        }else {
            map.put("showUsers","");
        }

        //根据菜单具体业务模块，传相应的参数即可

        String[] showMenusArray = showMenus.split(",");
        if(showMenusArray.length != 0){
            List<Long> idList = StringUtil.stringArrayToLongList(showMenusArray);
            Map<String,Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("idList",idList);
            List<Menu> menuList = menuService.getDataList(stringObjectMap);
            String menuString = menuService.menuListToString(menuList);

            map.put("showMenus",menuString);
        }else {
            map.put("showMenus","");
        }


        Integer count = groupService.setData(map);

        //根据菜单具体业务模块，传相应的参数即可

        authorityUserGroupService.updateUserUserGroupAuthorityByGroupId(id,showUsers);

        authorityMenuGroupService.updateMenuUserGroupAuthorityByGroupId(id,showMenus);
        return HttpResult.getSuccessfulResult(null);
    }

    @RequestMapping("/removeData")
    public HttpResult removeData(HttpServletRequest request, Model model,
                                 @RequestParam Long id
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        Integer count = groupService.removeData(map);
        return HttpResult.getSuccessfulResult(null);
    }

    @RequestMapping("/addData")
    public HttpResult addData(HttpServletRequest request, Model model,
                              @RequestParam String groupName,
                              @RequestParam(required = false,defaultValue = ",") String showUsers,
                              @RequestParam(required = false,defaultValue = ",") String showMenus
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("groupName",groupName);

        //获取登录用户id
        String userIdString =   CookieUtil.getCookieValueByCookieName(request, Constant.COOKIE_USER_ID);
        map.put("createUserId",Long.valueOf(userIdString));
        map.put("createTime",new Date());


        String[] showUsersArray = showUsers.split(",");
        if(showUsersArray.length != 0){
            List<Long> idList = StringUtil.stringArrayToLongList(showUsersArray);
            Map<String,Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("idList",idList);
            List<User> userList = userService.getDataList(stringObjectMap);
            String userString = userService.userListToString(userList);
            map.put("showUsers",userString);
        }else {
            map.put("showUsers","");
        }

        //根据菜单具体业务模块，传相应的参数即可

        String[] showMenusArray = showMenus.split(",");
        if(showMenusArray.length != 0){
            List<Long> idList = StringUtil.stringArrayToLongList(showMenusArray);
            Map<String,Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("idList",idList);
            List<Menu> menuList = menuService.getDataList(stringObjectMap);
            String menuString = menuService.menuListToString(menuList);

            map.put("showMenus",menuString);
        }else {
            map.put("showMenus","");
        }

        Long groupId = groupService.addData(map);

        return HttpResult.getSuccessfulResult(null);
    }

}
