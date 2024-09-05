package com.example.gateway.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "utilisateurs", url = "http://localhost:8074/api/v1/auth")
public interface Authinterface {

        @GetMapping("/validate")
        public String validateToken(@RequestParam("token") String token);

}
