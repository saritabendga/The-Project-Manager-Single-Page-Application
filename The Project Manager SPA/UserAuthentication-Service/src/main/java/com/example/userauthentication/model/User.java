package com.example.userauthentication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * The class "User" will be acting as the data model for the User Table in the database.
 * Please note that this class is annotated with @Entity annotation.
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation.
 * If it finds any, then it will begin the process of looking through that particular
 * Java object to recreate it as a table in your database.
 */
@Entity
public class User {

    /*
     * This class should have five fields (userId,firstName,lastName,
     * userPassword,userRole,userAddedDate). Out of these five fields, the field
     * userId should be the primary key. This class should also contain the getters
     * and setters for the fields, along with the no-arg , parameterized constructor
     * and toString method.The value of userAddedDate should not be accepted from
     * the user but should be always initialized with the system date
     */


    @Id
    String mailid;


    String username;
    String password;
    public String getMailid() {
        return mailid;
    }
    public void setMailid(String mailid) {
        this.mailid = mailid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }





}