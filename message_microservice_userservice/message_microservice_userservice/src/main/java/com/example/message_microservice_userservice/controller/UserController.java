package com.example.message_microservice_userservice.controller;

import com.example.message_microservice_userservice.client.feignClient;
import com.example.message_microservice_userservice.model.SendMessage;
import com.example.message_microservice_userservice.model.UserCredentials;
import com.example.message_microservice_userservice.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userservice")
public class UserController {



    @Autowired
    UserDetailsService uds;
    @GetMapping("")
    public String sucess(){
        return "signed in Successfully";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserCredentials ucrd){

        return uds.signup(ucrd);
    }

    @GetMapping("/getusers")
    public String[] users(){

        return uds.getusers();
    }
    @PostMapping("/getfriends")
    public String[] friends(){

        return uds.getfriends();
    }
    @PostMapping("/sendmessage")
    public Object[] sendMessage( @RequestBody SendMessage message){
        return uds.sendMessage(message);
    }
    @PostMapping("/viewmessage/{touser}")
    public Object[] viewMessage( @PathVariable String touser){
        return uds.viewMessage(touser);
    }
}
