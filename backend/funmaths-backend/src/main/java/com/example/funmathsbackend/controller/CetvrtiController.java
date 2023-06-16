package com.example.funmathsbackend.controller;

import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.service.TaskService4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mnozenje")
public class CetvrtiController {

    @Autowired
    private TaskService4 taskService;

    @GetMapping("/1")
    public Task getMnozenje1() {
        return taskService.generateMnozenjeprvi();
    }

    @GetMapping("/2")
    public Task getMnozenje2() {
        return taskService.generateMnozenjedrugi();
    }

    @GetMapping("/3")
    public Task getMnozenje3() {
        return taskService.generateMnozenjetreci();
    }

    @GetMapping("/4")
    public Task getMnozenje4() {
        return taskService.generateMnozenjecetvrti();
    }
}
