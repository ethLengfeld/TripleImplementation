package utils;

import apple.laf.JRSUIConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HitCounter {

    private static HitCounter counter = null;

    private static List<Long> timeStamps = new ArrayList<>();

    private HitCounter() {
    }

    public static HitCounter getInstance() {
        if (HitCounter.counter == null) {
            HitCounter.counter = new HitCounter();
        }
        return HitCounter.counter;
    }

    /*
    record(timestamp): records a hit that happened at timestamp
    total(): returns the total number of hits recorded
    range(lower, upper): returns the number of hits that occurred between timestamps lower and upper (inclusive)
     */
    public void record(long timestamp) {
        HitCounter.timeStamps.add(timestamp);
        Collections.sort(HitCounter.timeStamps);
    }

    public int total() {
        return HitCounter.timeStamps.size();
    }

    public int range(long lower, long upper) {
        int numInRange = 0;
        for (Long currTime : HitCounter.timeStamps) {
            if (currTime >= lower) {
                if (currTime <= upper) {
                    numInRange++;
                } else {
                    return numInRange;
                }
            }
        }

        return numInRange;
    }

}
