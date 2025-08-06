package com.example.message_microservice_userservice.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.ws.rs.core.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ClientConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        var auth= SecurityContextHolder.getContext().getAuthentication();
        if (auth!=null&&auth.isAuthenticated()&&!"anonymousUser".equals(auth.getPrincipal())){
            requestTemplate.header("username", auth.getName());
        }

    }
}
