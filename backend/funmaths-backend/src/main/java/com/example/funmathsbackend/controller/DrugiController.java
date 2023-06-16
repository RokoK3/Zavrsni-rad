package com.example.funmathsbackend.controller;

import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.model.TaskString;
import com.example.funmathsbackend.service.TaskService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dekadskeZnamenke")
public class DrugiController {

    @Autowired
    private TaskService2 taskService;

    @GetMapping("/1")
    public Task getDekadskeZnamenkeprvi() {
        return taskService.generateDekadskeZnamenkeprvi();
    }

    @GetMapping("/2")
    public TaskString getDekadskeZnamenkedrugi() {
        return taskService.generateDekadskeZnamenkedrugi();
    }
    @GetMapping("/3")
    public Task getDekadskeZnamenketreci() {
        return taskService.generateDekadskeZnamenketreci();
    }
}