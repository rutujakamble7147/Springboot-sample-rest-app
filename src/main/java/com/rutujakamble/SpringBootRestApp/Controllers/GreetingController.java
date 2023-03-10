package com.rutujakamble.SpringBootRestApp.Controllers;

import com.rutujakamble.SpringBootRestApp.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class GreetingController {
    private static final String template = "Hello,%s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting (@RequestParam(value = "name",defaultValue = "world")String name){
            log.info("request receive : name{}",name);
            return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

}
