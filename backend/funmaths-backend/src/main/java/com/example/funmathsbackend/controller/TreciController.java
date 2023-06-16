package com.example.funmathsbackend.controller;

import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.service.TaskService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/povrsina")
public class TreciController {

    @Autowired
    private TaskService3 taskService3;

    @GetMapping("/1")
    public Task getPovrsinaPrvi() {
        return taskService3.generatePovrsinaprvi();
    }

    @GetMapping("/2")
    public Task getPovrsinaDrugi() {
        return taskService3.generatePovrsinadrugi();
    }

    @GetMapping("/3")
    public Task getPovrsinaTreci() {
        return taskService3.generatePovrsinatreci();
    }

    @GetMapping("/4")
    public Task getPovrsinaCetvrti() {
        return taskService3.generatePovrsinacetvrti();
    }
}
