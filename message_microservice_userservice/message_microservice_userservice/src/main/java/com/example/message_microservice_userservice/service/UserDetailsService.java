package com.example.message_microservice_userservice.service;

import com.example.message_microservice_userservice.client.feignClient;
import com.example.message_microservice_userservice.model.SendMessage;
import com.example.message_microservice_userservice.model.UserCredentials;
import com.example.message_microservice_userservice.repository.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
@Autowired
feignClient client;
    @Autowired
    UserCredentialsRepo UserRepo;

    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials credentials= UserRepo.findByUsername(username);
        if (credentials==null){
            throw new UsernameNotFoundException("bro ,!! no user with that username found");
        }

        return new com.example.message_microservice_userservice.service.UserDetails(credentials);
    }

    public String signup(UserCredentials ucrd){
        if (UserRepo.findByUsername(ucrd.getUsername())==null) {
            ucrd.setPassword(encoder.encode(ucrd.getPassword()));
            UserRepo.save(ucrd);
        return "Logged in successfully";
        }
        return "Username already exists";
    }

    public String[] getusers(   ) {

     return client.getUsers();
    }

    public String[] getfriends() {
        return client.getFriends();
    }

    public Object[] sendMessage(SendMessage message) {
        return client.sendMessage(message);
    }

    public Object[] viewMessage(String touser) {
    return client.viewMessage(touser);
    }
}
