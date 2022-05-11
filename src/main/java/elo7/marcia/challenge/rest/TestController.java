package elo7.marcia.challenge.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/explore/mars")
    public @ResponseBody String exploreMars(@RequestBody String message) {
        List<String> lines = new ArrayList<>();
        return message;
    }

}
