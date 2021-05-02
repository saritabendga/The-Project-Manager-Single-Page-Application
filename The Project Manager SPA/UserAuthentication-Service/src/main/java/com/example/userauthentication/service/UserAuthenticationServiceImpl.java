package com.example.userauthentication.service;

import java.util.Date;
import java.util.Optional;

import com.example.userauthentication.exception.UserAlreadyExistsException;
import com.example.userauthentication.exception.UserNotFoundException;
import com.example.userauthentication.model.User;
import com.example.userauthentication.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {


    @Autowired
    UserAuthenticationRepository userauthenrepo;



    @Override
    public User findUserdata(String mailid, String password) throws UserNotFoundException {
        User userfound=userauthenrepo.findByMailidAndPassword(mailid, password);

        return userfound;

    }


    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {


        //Optional<User> userfound=userrepo.findById(user.getUserId());
        //System.out.println(userfound);

        Optional<User> optional = userauthenrepo.findById(user.getMailid());
        if(optional.isPresent()) {
            throw new UserAlreadyExistsException("exists");
        }

        userauthenrepo.save(user);
        return true;
    }


}


