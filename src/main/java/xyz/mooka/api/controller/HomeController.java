package xyz.mooka.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("hello")
    public ResponseEntity<?> hello() {
        logger.info("hi!!");
        return new ResponseEntity<>("here~", HttpStatus.OK);
    }
}
