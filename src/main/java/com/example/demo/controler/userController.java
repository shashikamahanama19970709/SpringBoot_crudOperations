package com.example.demo.controler;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/v1/user")
@CrossOrigin

public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }
    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){

        return userService.saveUser(userDTO);
    }


    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){

        return userService.updateUser(userDTO);
    }


    @DeleteMapping("deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){

        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserByUserid/{userId}")
    public UserDTO getUserByUserid(@PathVariable String userId){
       return  userService.getUserByUserid(userId);
    }

    @GetMapping("/getUserByUseridAndAddress/{userId}/{address}")
    public UserDTO getUserByUseridAndAddress(@PathVariable String userId,@PathVariable String address){
        return userService.getUserByUseridAndAddress(userId,address);
    }



}
