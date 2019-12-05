package com.ananas.backendapi.gatewayReader;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Task scheduling service for gateway task. Use TIME property to change time in minutes
 */
public class GatewayService implements Runnable {

    private int time;
    private TimeUnit timeUnit;

    public GatewayService(int time, TimeUnit timeUnit){
        this.time = time;
        this.timeUnit = timeUnit;
    }

    @Override
    public void run() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        GatewayTask task = new GatewayTask();

        executor.scheduleAtFixedRate(task, 0, time, timeUnit);
        try {
            TimeUnit.MILLISECONDS.sleep(20000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
