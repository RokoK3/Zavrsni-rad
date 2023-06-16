package com.example.funmathsbackend.controller;

import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.model.ZbrajanjeDo1000prvi;
import com.example.funmathsbackend.service.TaskService1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zbrajanjedo1000")
public class PrviController {

    private final TaskService1 taskService;

    public PrviController(TaskService1 taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/1")
    public ZbrajanjeDo1000prvi getZbrajanjeDo1000prvi() {
        return taskService.generateZbrajanjeDo1000prvi();
    }

    @GetMapping("/2")
    public Task getZbrajanjeDo1000drugi() {
        return taskService.generateZbrajanjeDo1000drugi();
    }

    @GetMapping("/3")
    public Task getZbrajanjeDo1000treci() {
        return taskService.generateZbrajanjeDo1000treci();
    }
}