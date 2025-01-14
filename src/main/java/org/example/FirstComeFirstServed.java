package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class FirstComeFirstServed {
    private final List<Integer> arrivalTimes;
    private final List<Integer> burtTimes;

    public FirstComeFirstServed(List<Integer> arrivalTimes, List<Integer> burtTimes) {
        this.arrivalTimes = arrivalTimes;
        this.burtTimes = burtTimes;
    }

    public float computation() {
        HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < arrivalTimes.size(); i++) {
            count += burtTimes.get(i);
            tmp.put(i, count);
        }

        // Find average time
        float totalWaitingTime = 0;
        for (int i = 0; i < arrivalTimes.size(); i++) {
            totalWaitingTime += tmp.get(i) - arrivalTimes.get(i) - burtTimes.get(i);
        }

        return totalWaitingTime / arrivalTimes.size();
    }
}