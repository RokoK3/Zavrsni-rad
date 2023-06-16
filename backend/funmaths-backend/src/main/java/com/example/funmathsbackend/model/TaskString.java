package com.example.funmathsbackend.model;

public class TaskString {
    private String taskText;
    private String solution;
    private String hint;

    public TaskString(String taskText, String solution, String hint) {
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

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
