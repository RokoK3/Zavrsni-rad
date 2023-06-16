package com.example.funmathsbackend.model;

public class Task {
    private String taskText;
    private int solution;
    private String hint;

    public Task(String taskText, int solution, String hint) {
        this.taskText = taskText;
        this.solution = solution;
        this.hint = hint;
    }

    // Getters and setters for each field

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}