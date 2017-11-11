package com.shenghe.index.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl-h on 2017/7/4.
 */
public class StringUtil {

    public static List<Long> stringArrayToLongList(String[] strings){
        List<Long> longList = new ArrayList<>();
        if(strings == null || strings.length == 0){
            return longList;
        }
        for(int i = 0;i < strings.length;i ++){
            longList.add(Long.valueOf(strings[i]));
        }
        return longList;
    }
}
