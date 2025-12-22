package com.user.userService.Controller;

import com.user.userService.Entity.UserEntity;
import com.user.userService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> findAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user){
       return userService.createUser(user);

    }

    @GetMapping("/{userId}")
    public UserEntity findUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{id}")
    private void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUserById(@PathVariable Long id,@RequestBody UserEntity user){
        return userService.updateUser(id,user);

    }




}
