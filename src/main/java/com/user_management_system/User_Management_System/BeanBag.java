package com.user_management_system.User_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanBag {
    @Bean
    public List<UserManagement> getUsers(){
        return new ArrayList<>();
    }




}
