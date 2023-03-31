package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.Repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired //to inject user Repo to user Service
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;

    }

    public List<UserDTO> getAllUsers(){
        List<User>userList =userRepo.findAll();
        return modelMapper.map(userList ,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }

    //select data from specific attribute
    //user id -> user details
    //seelct * from user where id =2

    public UserDTO getUserByUserid(String userId){
      User user=  userRepo.getUserByUserid(userId);
      return modelMapper.map(user ,UserDTO.class);
    }

    //user id,address ->use detils
    //select * from user where id=2 and address=colombo
    public UserDTO getUserByUseridAndAddress(String userId,String address){
        User user = userRepo.getUserByUseridAndAddress(userId,address);
        return modelMapper.map(user,UserDTO.class);

    }


}
