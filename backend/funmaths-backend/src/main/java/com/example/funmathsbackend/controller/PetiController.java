package com.example.funmathsbackend.controller;

import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.service.TaskService5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dijeljenje")
public class PetiController {

    @Autowired
    private TaskService5 taskService5;

    @GetMapping("/1")
    public Task getDijeljenjePrvi() {
        return taskService5.generateDijeljenjeprvi();
    }

    @GetMapping("/2")
    public Task getDijeljenjeDrugi() {
        return taskService5.generateDijeljenjedrugi();
    }

    @GetMapping("/3")
    public Task getDijeljenjeTreci() {
        return taskService5.generateDijeljenjetreci();
    }
}
