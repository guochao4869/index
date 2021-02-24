package com.shangxin.demo.utils;

import com.shangxin.demo.pojo.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    public static final String SUBJECT = "guli-user";
    //秘钥
    public static final String APP_SECRET = "79e7c69681b8270162386e6daa53d1dc";
    //过期时间，毫秒，30分钟
    public static final long EXPIRE = 1000 * 60 * 30;
    /**
     * 生成Jwt令牌
     * @return
     */
    public static String generateJwt(Member member){
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT") //令牌类型
                .setHeaderParam("alg", "HS256") //签名算法
                .setSubject(SUBJECT) //令牌主题
                .setIssuedAt(new Date()) //签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE)) //过期时间
                .claim("id", member.getId())
                .claim("nickname", member.getNickname())
                .claim("avatar", member.getAvatar())
                .signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();
        return token;
    }
    /**
     * 校验jwt
     * @param jwtToken
     * @return
     */
    public static Claims checkJwt(String jwtToken){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return claims;
    }
}
