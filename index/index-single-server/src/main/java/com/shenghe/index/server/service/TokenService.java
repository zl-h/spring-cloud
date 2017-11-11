package com.shenghe.index.server.service;


import com.shenghe.index.common.entity.User;

/**
 * Created by zl-h on 2017/6/14.
 */
public interface TokenService {

    String getToken(User user);

    boolean validToken(String token);

    //使Token失效
    boolean setInValidToken(String token);

}
