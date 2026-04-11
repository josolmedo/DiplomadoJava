package edu.unam.spring_security_101.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/auth")
public class HelloWorldController {

    @GetMapping("/welcome")
    public String helloWorld(){
        log.info("Estoy entrando a mi LOG!!!!");
        return "Hello World";
    }

    /*public String helloWorld2(int a, Class b){
        try{
            log.trace();
        }catch(Exception e){
            log.error("Mensaje {}", e);
        }
        log.info("El valor de la variable es de {} {}",a,b);
        return "";
    }*/
}
