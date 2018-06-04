package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sokolov
 */
@RestController
public class helloController {
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello dun-duk";
    }
}
