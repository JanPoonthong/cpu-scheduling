package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoundRobin {
    private final List<Integer> arrivalTimes;
    private final List<Integer> burtTimes;

    public RoundRobin(List<Integer> arrivalTimes, List<Integer> burtTimes) {
        this.arrivalTimes = arrivalTimes;
        this.burtTimes = burtTimes;
    }

    public List<Integer> computation() {
        return new ArrayList<>(Arrays.asList(1, 2));
    }
}
