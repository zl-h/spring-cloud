package com.shenghe.index.middleware.controller;

import com.shenghe.common.entity.HttpResult;
import com.shenghe.index.common.antdEntity.AntdColumn;
import com.shenghe.index.common.antdEntity.AntdResult;
import com.shenghe.index.common.constant.Constant;
import com.shenghe.index.common.entity.Group;
import com.shenghe.index.common.entity.Language;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/10/20.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    ColumnService columnService;

    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

    @Autowired
    AuthorityUserGroupService authorityUserGroupService;

    @RequestMapping("/getTableData")
    public HttpResult getTableData(HttpServletRequest request, @RequestParam Map<String,Object> map){
        String languageId = CookieUtil.getCookieValueByCookieName(request, Constant.COOKIE_LANGUAGE_ID);
        Long langId = null;
        if(languageId != null)langId = Long.valueOf(languageId);
        List<AntdColumn> columnList = columnService.getColumns(IndexConstant.systemName,IndexConstant.userModualName,langId);
        List<User> languageList = userService.getDataList(map);
        Long count = userService.getDataListCount(map);
        AntdResult antdResult = AntdResult.getAntdResult(languageList,count,columnList,null);
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
                              @RequestParam String userName,
                              @RequestParam String trueName,
                              @RequestParam String password,
                              @RequestParam Long defaultLangId,
                              @RequestParam(required = false,defaultValue = ",") String showGroups
    ){
        //修改用户表数据
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("userName",userName);
        map.put("trueName",trueName);
        map.put("password",password);
        map.put("defaultLangId",defaultLangId);

        String[] showGroupsArray = showGroups.split(",");
        if(showGroupsArray.length != 0){
            List<Long> idList = StringUtil.stringArrayToLongList(showGroupsArray);
            Map<String,Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("idList",idList);
            List<Group> groupList = groupService.getDataList(stringObjectMap);
            String groupString = groupService.groupListToString(groupList);
            map.put("showGroups",groupString);
        }else {
            map.put("showGroups","");
        }

        Integer count = userService.setData(map);
        //修改用户-用户组权限表数据，先删除该用户的全部数据，再插入
        //根据组id得到相应的祖名
        authorityUserGroupService.updateUserUserGroupAuthority(id,showGroups);
        return HttpResult.getSuccessfulResult(null);
    }

    @RequestMapping("/removeData")
    public HttpResult removeData(HttpServletRequest request, Model model,
                                 @RequestParam Long id
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        Integer count = userService.removeData(map);
        return HttpResult.getSuccessfulResult(null);
    }

    @RequestMapping("/addData")
    public HttpResult addData(HttpServletRequest request, Model model,
                              @RequestParam String userLanguage,
                              @RequestParam String remark
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("userLanguage",userLanguage);
        map.put("remark",remark);
        Long count = userService.addData(map);
        //根据菜单具体业务模块，传相应的参数即可
        return HttpResult.getSuccessfulResult(null);
    }

}
