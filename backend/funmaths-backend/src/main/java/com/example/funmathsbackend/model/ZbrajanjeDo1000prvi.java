package com.example.funmathsbackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ZbrajanjeDo1000prvi {
    private final int x;
    private final int y;
    private final int z;
    private final int solution;
    private final String hint;
    private final String taskText;

    public ZbrajanjeDo1000prvi(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.solution = x + y + z;
        this.hint = "Zbrojite tri broja: " + x + ", " + y + " i " + z + ".";
        this.taskText = "Pribrojnici su " + x + ", " + y + " i " + z + ". Koliko iznosi njihov zbroj?";
    }
}