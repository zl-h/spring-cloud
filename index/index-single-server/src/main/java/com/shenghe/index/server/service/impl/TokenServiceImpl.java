package com.shenghe.index.server.service.impl;

import com.shenghe.index.common.entity.Token;
import com.shenghe.index.common.entity.User;
import com.shenghe.index.server.service.TokenService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zl-h on 2017/6/14.
 */
@Service
public class TokenServiceImpl implements TokenService {

    //过期时间15分钟
    static Integer expireTime = 15000;

    static ConcurrentHashMap<String,Token> tokenConcurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public String getToken(User user) {
        Token token = new Token();
        token.setStartTime(DateTime.now());
        token.setLastAccessTime(DateTime.now());
        token.setEndTime(token.getLastAccessTime().plusMinutes(expireTime));
        token.setUser(user);
        token.setId(getUniqueToken());
        tokenConcurrentHashMap.put(token.getId(),token);
        return token.getId();
    }

    @Override
    public boolean validToken(String tokenId) {
        if(tokenId == null)return false;
        Token token = tokenConcurrentHashMap.get(tokenId);
        if(token != null && token.getEndTime().isAfterNow()){
            //自动激活
            token.setLastAccessTime(DateTime.now());
            token.setEndTime(token.getLastAccessTime().plusMinutes(expireTime));
            tokenConcurrentHashMap.put(token.getId(),token);
            return true;
        }
        return false;
    }

    @Override
    public boolean setInValidToken(String token) {
        tokenConcurrentHashMap.remove(token);
        return validToken(token);
    }

    String getUniqueToken(){
        UUID uuid = UUID.randomUUID();
        // 得到对象产生的ID
        String token = uuid.toString();
        // 转换为大写
        token = token.toUpperCase();
        // 替换 “-”变成空格
        token = token.replaceAll("-", "");

        return token;
    }
}
