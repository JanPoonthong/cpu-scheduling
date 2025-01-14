package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RoundRobin {
    private final List<Integer> arrivalTimes;
    private final List<Integer> burtTimes;
    private final int quantum;

    public RoundRobin(List<Integer> arrivalTimes, List<Integer> burtTimes, int quantum) {
        this.arrivalTimes = arrivalTimes;
        this.burtTimes = burtTimes;
        this.quantum = quantum;
    }

    public float computation() {
        HashMap<Integer, Integer> completionTimes = new HashMap<>();
        List<Integer> tmpBurstTime = new ArrayList<>(burtTimes);

        int currentTime = 0;

        while (true) {
            boolean allZero = tmpBurstTime.stream().allMatch(num -> num == 0);
            if (allZero) {
                break;
            } else {
                for (int i = 0; i < arrivalTimes.size(); i++) {
                    if (tmpBurstTime.get(i) > 0) {
                        if (tmpBurstTime.get(i) <= quantum) {
                            currentTime += tmpBurstTime.get(i);
                            tmpBurstTime.set(i, 0);
                            completionTimes.put(i, currentTime);
                        } else {
                            currentTime += quantum;
                            tmpBurstTime.set(i, tmpBurstTime.get(i) - quantum);
                        }
                    }
                }
            }
        }

        float totalWaitingTime = 0;
        for (int i = 0; i < arrivalTimes.size(); i++) {
            totalWaitingTime += completionTimes.get(i) - arrivalTimes.get(i) - burtTimes.get(i);
        }

        return totalWaitingTime / arrivalTimes.size();
    }


}
