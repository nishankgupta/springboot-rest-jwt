package com.nishank.springrestjwt.util;

import com.nishank.springrestjwt.bean.User;
import com.nishank.springrestjwt.bean.UserAuth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nishank Gupta on 24-May-18.
 */
public class JwtUtil {

    public static User parseToken(String jwtToken, String secret) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken).getBody();
            User user = new User();
            user.setUserName((String) claims.get("username"));
            user.setAge((int) claims.get("age"));
            user.setSex(((String) claims.get("sex")).charAt(0));

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public static UserAuth getUserAuth(User user, String secret) {
        Map<String, Object> data = new HashMap();
        data.put("username", user.getUserName());
        data.put("age", user.getAge());
        data.put("sex", user.getSex());

        String token = Jwts.builder().setClaims(data).signWith(SignatureAlgorithm.HS512, secret).compact();

        UserAuth userAuth = new UserAuth();
        userAuth.setToken(token);

        return userAuth;
    }
}
