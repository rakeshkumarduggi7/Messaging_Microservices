package com.example.message_microservice_messageService.service;

import com.example.message_microservice_messageService.model.Conversations;
import com.example.message_microservice_messageService.model.SendMessage;
import com.example.message_microservice_messageService.repository.ConversationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {
@Autowired
    ConversationsRepo repo;

    public String[] getFriends(String username) {
return repo.getFriends(username);
    }

    public String[] getUsers(String username) {
        return repo.getUsers(username);
    }

    public Object[] sendMessage(String username,SendMessage message) {
        Conversations conversations=new Conversations();
        conversations.setMessage(message.getMessage());
        conversations.setTo_username(message.getTousername());
        conversations.setDate(LocalDateTime.now());
        conversations.setFrom_username(username);
repo.save(conversations);
return repo.getConversations(username,message.getTousername());
    }

    public Object[] getMessages(String username, String touser) {
      return  repo.getConversations(username,touser);
    }
}
