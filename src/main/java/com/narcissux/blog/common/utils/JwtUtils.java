package com.narcissux.blog.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.narcissux.blog.common.exception.RestException;
import com.narcissux.blog.component.SpringContextUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.security.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * jwt工具类
 *
 * @author xiaye
 * @date 2019/5/7
 */
public class JwtUtils {

    //加载jwt.jks文件
    private static InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks");
    private static Key privateKey = null;
    private static Key publicKey = null;
    private static final long EXPIRE = 30 * 60 * 1000; //30分钟超时
    private static final String UID = "uid";

    @Autowired
    private static RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtils.getBean("redisTemplate");

    static {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(inputStream, "123456".toCharArray());
            privateKey = (PrivateKey) keyStore.getKey("jwt", "123456".toCharArray());
            publicKey = keyStore.getCertificate("jwt").getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取公钥
    public static Key getPublicKey() {
        return publicKey;
    }

    /**
     * 生成jwt token
     */
    /**
     * 生成token
     *
     * @param uid
     * @return
     */
    public static String generateToken(Integer uid) {
        //过期时间
        Date expireDate = new Date(new Date().getTime() + EXPIRE);
        Claims claims = new DefaultClaims();
        Map<String, Object> map = new HashMap<>();
        map.put("group", "narcissux");
        map.put(UID, uid);
        claims.setId(uid.toString())
                .setIssuer("xiaye").putAll(map);

        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(expireDate)
                .signWith(privateKey)
                .compact();

        // 存进redis
        redisTemplate.opsForValue().set(uid.toString(), token);
        redisTemplate.expire(uid.toString(), 30, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 生成jwt token
     */
    /**
     * 生成token
     *
     * @param uid
     * @return
     */
    public static String generateToken(Integer uid, Long expire) {
        //过期时间
        Date expireDate = new Date(new Date().getTime() + expire);
        Claims claims = new DefaultClaims();
        Map<String, Object> map = new HashMap<>();
        map.put("group", "narcissux");
        map.put(UID, uid);
        claims.setId(uid.toString())
                .setIssuer("xiaye").putAll(map);

        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(expireDate)
                .signWith(privateKey)
                .compact();

        // 存进redis
        redisTemplate.opsForValue().set(uid.toString(), token);
        redisTemplate.expire(uid.toString(), 30, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 解析Claims
     *
     * @param token
     * @return
     */
    public static Claims getClaim(String token) throws JwtException {
        return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token)
                .getBody();
    }
    /**
     * 解析Claims
     *
     * @param token
     * @return
     */
    public static JSONObject getJson(String token) {
        String[] s = token.split("\\.");
        String decode = new String(Base64.decodeBase64(s[1].getBytes()));
        return JSONObject.parseObject(decode);
    }

    /**
     * 获取jwt发布时间
     */
    public static Date getIssuedAt(String token) {
        return getClaim(token).getIssuedAt();
    }

    /**
     * 获取UID
     */
    public static Integer getUid(String token) {
        return TypeUtils.castToInt(getClaim(token).get(UID));
    }

    /**
     * 获取jwt失效时间
     */
    public static Date getExpiration(String token) {
        return getClaim(token).getExpiration();
    }

    /**
     * 验证token是否失效
     *
     * @param token
     * @return true:过期   false:没过期
     */
    public static String checkExpired(String token) {
        try {
            Claims claim = getClaim(token);
            final Date expiration = getExpiration(token);
            Long subtraction = expiration.getTime() - System.currentTimeMillis();
            // 如果在3分钟内，刷新token;
            if (0 < subtraction && subtraction < 1000 * 60 * 3) {
                // 检查是否这个token 是否存在，如果不存在，表示已经发行过新的token
                if (!redisTemplate.hasKey(claim.get(UID).toString())) {
                    return token;
                }
                return renewToken(token, Integer.parseInt(claim.getId()));
            } else if (subtraction >= 1000 * 60 * 3) {
                return token;
            }
        } catch (Exception e) {
            throw new RestException("解析Jwt失败：" + e.getMessage());
        }
        throw new RestException("token已超时");
    }


    /**
     * 获取新的token
     *
     * @param token
     * @param uid
     * @return
     */
    private static String renewToken(String token, Integer uid) {

        redisTemplate.delete(uid.toString());
        String newToken = generateToken(uid);
        return newToken;
    }

}
