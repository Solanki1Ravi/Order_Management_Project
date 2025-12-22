package com.user.userService.Services;

import com.user.userService.Entity.UserEntity;
import com.user.userService.Repo.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public UserEntity getUserById(Long id){
        return userRepo.findById(id).orElseThrow();

    }


    public List<UserEntity> getAllUsers(){
        return userRepo.findAll();
    }


    public UserEntity createUser(UserEntity user){
        return userRepo.save(user);

    }

    public void deleteUserById(Long id){
       userRepo.deleteById(id);
    }

    public UserEntity updateUser(@PathVariable Long id , @RequestBody UserEntity newUser){
        UserEntity userInDb = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found with id "+id));
        userInDb.setName(newUser.getName());
        userInDb.setEmail(newUser.getEmail());

      return   userRepo.save(userInDb);

    }
}
