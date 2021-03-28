package xyz.mooka.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("hello")
    public ResponseEntity<?> hello() {
        System.out.println("hi!!");
        return new ResponseEntity<>("here~", HttpStatus.OK);
    }
}
