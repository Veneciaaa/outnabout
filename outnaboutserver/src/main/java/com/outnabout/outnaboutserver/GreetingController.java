package com.outnabout.outnaboutserver;

/**
 * Created by Josh on 2/25/17.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    //private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/initiateactiveuser")
    public ActiveUser greeting() {
        return new ActiveUser(0, "default", 0.0, 0.0);
    }
}