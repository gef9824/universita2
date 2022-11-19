package com.example.universita2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping(path = "/")
    public String helloRest(){
        return "Ciao sciordina";
    }
}
