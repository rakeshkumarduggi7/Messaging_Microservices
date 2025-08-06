package com.example.message_microservice_messageService.repository;

import com.example.message_microservice_messageService.model.Conversations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationsRepo extends JpaRepository<Conversations,Integer> {

    @Query(value = "select from_username from Conversations where  to_username=:username union select to_username from Conversations where   from_username =:username  ",nativeQuery = true)
public String[] getFriends(@Param("username")String username);

    @Query(value = "select from_username from Conversations where  from_username!=:username union select to_username from Conversations where   to_username !=:username  ",nativeQuery = true)
    public String[] getUsers(@Param("username")String username);

    @Query(value = "select from_username,message from conversations where (from_username=:username and to_username=:tousername) or (from_username=:tousername and to_username=:username) order by date asc ",nativeQuery = true)
    Object[] getConversations(@Param("username") String username, @Param("tousername") String tousername);
}
