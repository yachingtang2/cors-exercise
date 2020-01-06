package com.tang.corsexercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

  private static final String templateWithOneParam = "Hello, %s!";
  private static final String templateWithTwoParams = "Hello, %s! %s";
  private final AtomicLong counter = new AtomicLong();

//  @CrossOrigin(origins = "http://localhost:9000")
  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name,
    @RequestParam(required=false, defaultValue="") String nickName) {
    String string = nickName.isBlank() ? String.format(templateWithOneParam, name) : String.format(templateWithTwoParams, name, nickName);
    return new Greeting(counter.incrementAndGet(), string);
  }
}
