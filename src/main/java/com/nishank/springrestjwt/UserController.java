package com.nishank.springrestjwt;

import com.nishank.springrestjwt.bean.User;
import com.nishank.springrestjwt.bean.UserAuth;
import com.nishank.springrestjwt.util.JwtUtil;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Nishank Gupta on 24-May-18.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Value("${api.secret}")
    private String secret;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity<User> getUser(@RequestHeader(name = "Authorization") String authorization) {

        User user = JwtUtil.parseToken(authorization, secret);

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserAuth> login(String username, String password) {
        //validate user against database
        User user = new User();
        user.setUserName(username);
        user.setAge(30);
        user.setSex('M');

        return new ResponseEntity<UserAuth>(JwtUtil.getUserAuth(user, secret), HttpStatus.OK);
    }
}
