package com.ananas.backendapi.gatewayReader;

import com.ananas.backendapi.util.ConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GatewayService implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(GatewayService.class);

    private int time;
    private TimeUnit timeUnit;
    private String url;
    private boolean debug;

    public GatewayService(ConfigProperties properties){
        this.time = properties.getTime();
        this.timeUnit = TimeUnit.MINUTES;
        this.url = properties.getUrl();
        this.debug = properties.isDebug();
    }

    @Override
    public void run() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        GatewayTask task = new GatewayTask(url, debug);

        executor.scheduleAtFixedRate(task, 0, time, timeUnit);
        try {
            TimeUnit.MILLISECONDS.sleep(20000);
        }
        catch (InterruptedException e) {
            logger.error("Thread did not run");
        }
    }
}
