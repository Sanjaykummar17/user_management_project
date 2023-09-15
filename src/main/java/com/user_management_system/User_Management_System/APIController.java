package com.user_management_system.User_Management_System;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
public class APIController {

@Autowired
List<UserManagement> usersData;


    @PostMapping("addUsers")             //    addUser
    public String  addUsers(@RequestBody List<UserManagement> addUser){
        usersData.addAll(addUser);
        return "User Added Successfully";
    }

    @PostMapping("addSingleUser")           //     Single User Adding
    public  String addUsers(@RequestBody UserManagement user) {
        usersData.add(user);
        return "Single User Added Successfully!!";
    }

    @GetMapping("get_userId/id/{id}")         //    getUser/{userid}
    public String getUserId(@PathVariable Integer id){
        for(UserManagement userId : usersData) {
            if (userId.getUserId().equals(id)) {
                return usersData.toString();
            }
        }
        return "Invalid userId";
    }

    @GetMapping("getAllUsers")           //    getAllUser
    public  List<UserManagement> getAllUsers(){
        return usersData;
    }

    @DeleteMapping("delete_User_Id/{id}")     //    delete users
    public String removeUsedById(@PathVariable Integer id){
        for(UserManagement userId : usersData){
            if(userId.getUserId().equals(id)){
                usersData.remove(userId);
                return "User Deleted Successfully!!";
            }
        }
        return "Invalid UserId";
    }

    @PutMapping("updateId/id/{id}/updateId")                // update id
    public String setTodoStatusById(@PathVariable Integer id,@RequestParam Integer updateId)
    {
        for(UserManagement todo : usersData)
        {
            if(todo.getUserId().equals(id))
            {
                todo.setUserId(updateId);
                return "userId : "   + id  + " updated to " +  updateId;
            }
        }

        return "Invalid id";
    }


}
