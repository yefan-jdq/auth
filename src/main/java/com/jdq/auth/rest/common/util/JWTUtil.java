package com.jdq.auth.rest.common.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * JWT加密工具
 */
public class JWTUtil {
    /**
     * 过期时间24小时
     */
    public static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /**
     * 生成签名,会过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {
	Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
	Algorithm algorithm = Algorithm.HMAC256(secret);
	// 附带username信息
	return JWT.create()
		.withClaim("username", username.toLowerCase())
		.withExpiresAt(date)
		.sign(algorithm);
    }

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
	Algorithm algorithm = Algorithm.HMAC256(secret);
	JWTVerifier verifier = JWT.require(algorithm)
		.withClaim("username", username.toLowerCase())
		.build();
	verifier.verify(token);
	return true;
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
	DecodedJWT jwt = JWT.decode(token);
	return jwt.getClaim("username").asString();
    }
}