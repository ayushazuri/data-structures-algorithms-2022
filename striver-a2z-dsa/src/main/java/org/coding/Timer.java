package org.coding;

import java.time.Duration;
import java.time.Instant;

public class Timer {
    Instant start;
    Instant end;

    public void start(){
        start = Instant.now();
    }

    public void calculateTime(){
        end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Duration between start to end is = " + duration.toMillis());
    }
}
