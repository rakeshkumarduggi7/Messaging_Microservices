package com.example.message_microservice_messageService.controller;

import com.example.message_microservice_messageService.model.Conversations;
import com.example.message_microservice_messageService.model.SendMessage;
import com.example.message_microservice_messageService.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messageservice")
public class MessageServiceController {
@Autowired
    MessageService service;
    @GetMapping("/getusers")
    public String[] getUsers(@RequestHeader("")String username ){
return service.getUsers(username);
    }
    @GetMapping("/getfriends")
    public String[] getFriends(@RequestHeader("username")String username ){
        return service.getFriends(username);
    }

    @PostMapping("/sendmessage")
    public Object[] sendMessage(@RequestHeader("username")String username ,@RequestBody SendMessage message){

        return  service.sendMessage(username,message);
    }

    @PostMapping("/viewmessage/{touser}")
    public Object[] viewMessage(@RequestHeader("username") String username,@PathVariable String touser){

        return  service.getMessages(username,touser);
    }

}
