package com.example.message_microservice_userservice.client;

import com.example.message_microservice_userservice.model.SendMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="message-microservice-messageservice" )
public interface feignClient {
    @GetMapping("/messageservice/getusers")
    public String[] getUsers( );
    @GetMapping("/messageservice/getfriends")
    public String[] getFriends( );

    @PostMapping("/messageservice/sendmessage")
    public Object[] sendMessage( @RequestBody SendMessage message);


    @PostMapping("/messageservice/viewmessage/{touser}")
    public Object[] viewMessage( @PathVariable String touser);

}
