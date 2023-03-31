package com.example.demo.Repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository <User,Integer>{
    @Query(value="select * from user where id=?1",nativeQuery = true)
    User getUserByUserid(String userId);

    @Query(value = "select * from user where id=?/1 and address=?2",nativeQuery = true)
    User getUserByUseridAndAddress(String userId,String address);


}
