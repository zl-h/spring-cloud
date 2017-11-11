package com.shenghe.index.middleware.controller;

import com.shenghe.common.entity.HttpResult;
import com.shenghe.index.common.antdEntity.AntdColumn;
import com.shenghe.index.common.antdEntity.AntdResult;
import com.shenghe.index.common.constant.Constant;
import com.shenghe.index.common.entity.*;
import com.shenghe.index.common.util.CookieUtil;
import com.shenghe.index.common.util.MenuUtil;
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
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    ColumnService columnService;

    @Autowired
    MenuService menuService;

    @Autowired
    GroupService groupService;

    @Autowired
    AuthorityMenuGroupService authorityMenuGroupService;

    @RequestMapping("/getIndexMenu")
    public HttpResult getIndexMenu(HttpServletRequest request,
                                   @RequestParam Map<String,Object> map){
        String userLanguageId =   CookieUtil.getCookieValueByCookieName(request, Constant.COOKIE_LANGUAGE_ID);
        if(userLanguageId != null){
            map.put("languageId",userLanguageId);
        }
        List<Menu> menuList = menuService.getDataList(map);
        List<MyMenu> menuGroupList = MenuUtil.getMyMenuList(menuList);
        return HttpResult.getSuccessfulResult(menuGroupList);
//        List<MenuGroup> menuGroupList = MenuUtilNew.getMenuGroupListBtMenuList(menuList);

    }

    @RequestMapping("/getTableData")
    public HttpResult getTableData(HttpServletRequest request, @RequestParam Map<String,Object> map){
        String languageId = CookieUtil.getCookieValueByCookieName(request, Constant.COOKIE_LANGUAGE_ID);
        Long langId = null;
        if(languageId != null)langId = Long.valueOf(languageId);
        List<AntdColumn> columnList = columnService.getColumns(IndexConstant.systemName,IndexConstant.userModualName,langId);
        List<Menu> languageList = menuService.getDataList(map);
        Long count = menuService.getDataListCount(map);
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
        List<Menu> menuList = menuService.getDataList(map);
        return HttpResult.getSuccessfulResult(menuList);
    }

    /**
     * 数据修改接口
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/setData")
    public HttpResult setData(HttpServletRequest request, Model model,
                              @RequestParam Long id,
                              @RequestParam String menuName,
                              @RequestParam String menuUrl,
     /*                         @RequestParam String parentMenu,*/
                              @RequestParam String sort,
                              @RequestParam String menuType,
                              @RequestParam String menuIndex,
                              @RequestParam(required = false,defaultValue = ",") String showGroups,
                              @RequestParam(required = false) Long languageId
    ){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("menuName",menuName);
        map.put("menuUrl",menuUrl);
 /*       map.put("parentMenu",parentMenu);*/
        map.put("sort",sort);
        map.put("menuType",menuType);
        map.put("menuIndex",menuIndex);
        map.put("languageId",languageId);


        //校验menuIndex的唯一性
        Map<String,Object> checkMap = new HashMap<>();
        checkMap.put("menuIndex",menuIndex);
        checkMap.put("languageId",languageId);
        List<Menu> checkMenus = menuService.getDataList(checkMap);
        if(checkMenus.size() > 0){
            if(checkMenus.get(0).getId() != id){
                return HttpResult.getFailureResult("不唯一");
            }
        }




/*        String[] showGroupsArray = showGroups.split(",");
        List<Long> idList = StringUtil.stringArrayToLongList(showGroupsArray);
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("idList",idList);
        List<Group> groupList = groupService.getDataList(stringObjectMap);
        String groupString = groupService.groupListToString(groupList);

        map.put("showGroups",groupString);

        Integer count = menuService.setData(map);*/
        //根据菜单具体业务模块，传相应的参数即可
        authorityMenuGroupService.updateMenuUserGroupAuthority(id,showGroups);

     /*   groupService.reset();*/

        return HttpResult.getSuccessfulResult(null);
    }

    @RequestMapping("/removeData")
    public HttpResult removeData(HttpServletRequest request, Model model,
                                 @RequestParam Long id
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        Integer count = menuService.removeData(map);
        return HttpResult.getSuccessfulResult(null);
    }

    @RequestMapping("/addData")
    public HttpResult addData(HttpServletRequest request,
                              @RequestParam String menuName,
                              @RequestParam String menuUrl,
                       /*       @RequestParam String parentMenu,*/
                              @RequestParam String sort,
                              @RequestParam String menuType,
                              @RequestParam String menuIndex,
                              @RequestParam(required = false,defaultValue = ",") String showGroups,
                              @RequestParam(required = false) Long languageId
    ){
        //不要设置缓存
        Map<String,Object> map = new HashMap<>();
        map.put("menuName",menuName);
        map.put("menuUrl",menuUrl);
/*        map.put("parentMenu",parentMenu);*/
        map.put("sort",sort);
        map.put("menuType",menuType);
        map.put("menuIndex",menuIndex);
        map.put("languageId",languageId);


        //校验menuIndex的唯一性
        Map<String,Object> checkMap = new HashMap<>();
        checkMap.put("menuIndex",menuIndex);
        checkMap.put("languageId",languageId);
        List<Menu> checkMenus = menuService.getDataList(checkMap);
        if(checkMenus.size() > 0){
            return HttpResult.getFailureResult("不唯一");
        }



        //获取登录用户id
        String userIdString =   CookieUtil.getCookieValueByCookieName(request, Constant.COOKIE_USER_ID);
        map.put("createUserId",Long.valueOf(userIdString));
        map.put("createTime",new Date());

        String[] showGroupsArray = showGroups.split(",");
        List<Long> idList = StringUtil.stringArrayToLongList(showGroupsArray);
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("idList",idList);
        List<Group> groupList = groupService.getDataList(stringObjectMap);
        String groupString = groupService.groupListToString(groupList);

        map.put("showGroups",groupString);

        Long menuId = menuService.addData(map);
        //根据菜单具体业务模块，传相应的参数即可

        authorityMenuGroupService.updateMenuUserGroupAuthority(menuId,showGroups);
        //根据菜单具体业务模块，传相应的参数即可
        return HttpResult.getSuccessfulResult(null);
    }

}
