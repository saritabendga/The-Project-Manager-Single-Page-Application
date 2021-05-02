package com.example.userauthentication.service;


import com.example.userauthentication.exception.UserAlreadyExistsException;
import com.example.userauthentication.exception.UserNotFoundException;
import com.example.userauthentication.model.User;

public interface UserAuthenticationService {


    public User findUserdata(String mailid, String password) throws UserNotFoundException, UserNotFoundException;

    boolean saveUser(User user) throws UserAlreadyExistsException, UserAlreadyExistsException;
}
