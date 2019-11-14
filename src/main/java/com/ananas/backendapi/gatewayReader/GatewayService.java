package com.ananas.backendapi.gatewayReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Task scheduling service for gateway task. Use TIME property to change time in minutes
public class GatewayService implements Runnable {

    private int TIME;

    public GatewayService(int time){
        TIME = time;
    }

    @Override
    public void run() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        GatewayTask task = new GatewayTask();

        executor.scheduleAtFixedRate(task, 0, TIME, TimeUnit.MINUTES);
        try {
            TimeUnit.MILLISECONDS.sleep(20000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
