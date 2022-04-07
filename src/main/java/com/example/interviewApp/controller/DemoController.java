package com.example.interviewApp.controller;

import com.example.interviewApp.model.Runner;
import com.example.interviewApp.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) { this.demoService = demoService; }

    @GetMapping(value = "/unique")
    public ResponseEntity<String> firstUniqueProduct(@RequestParam("products") String[] products) {
        return ResponseEntity.ok().body(demoService.firstUniqueProduct(products));
    }

    @GetMapping("/runner")
    public void getRunnerTasks() {
      demoService.getTasks(new Runner());
    }
}
