package com.example.userauthentication.repository;

import com.example.userauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<User, String> {


    User findByMailidAndPassword(String mailid,String pwd);
}
