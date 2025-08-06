package com.example.message_microservice_userservice.repository;

import com.example.message_microservice_userservice.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Integer> {

    @Query(value = "select * from user_credentials where username=:username",nativeQuery = true )
    public UserCredentials findByUsername(@Param("username") String username);
}
