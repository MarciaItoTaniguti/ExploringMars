package elo7.marcia.challenge.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/")
    public String test() {
        return "Hello Word!";
    }

    @PostMapping("/{message}")
    public String postTest(@PathVariable("message") String message) {
        return message;
    }

    @PostMapping("/")
    public @ResponseBody String postTest2(@RequestBody String message) {
        return message;
    }

}
