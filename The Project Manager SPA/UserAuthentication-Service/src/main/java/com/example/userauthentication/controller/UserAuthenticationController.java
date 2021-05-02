package com.example.userauthentication.controller;

import java.util.Date;

import java.util.HashMap;

import com.example.userauthentication.exception.UserAlreadyExistsException;
import com.example.userauthentication.model.User;
import com.example.userauthentication.service.UserAuthenticationService;
import org.dom4j.util.UserDataElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/auth")
public class UserAuthenticationController {

    @Autowired
    UserAuthenticationService userauthenservice;

    User user;



    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody User userdata) throws UserAlreadyExistsException
    {
        try {
            userauthenservice.saveUser(userdata);
            return new ResponseEntity<User>(userdata,HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException e) {
            return new ResponseEntity<String>("Can't add",HttpStatus.CONFLICT);
        }


    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@RequestBody User userdata) throws Exception
    {

        User userfound=	userauthenservice.findUserdata(userdata.getMailid(),userdata.getPassword());

        if (userfound==null)
        {
            return new ResponseEntity<String>("Invalid user/password",HttpStatus.UNAUTHORIZED);
        }

        else
        {
            String token=getToken(userfound);
            HashMap map=new HashMap();
            map.put("mytoken", token);
            return new ResponseEntity<HashMap>(map,HttpStatus.ACCEPTED);
        }
    }





    // Generate JWT token
    public String getToken(User user) throws Exception {


        long expirytime = 10_000_000;

        return Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirytime))
                .signWith(SignatureAlgorithm.HS256, "ibmkey")
                .compact();


    }

    }

