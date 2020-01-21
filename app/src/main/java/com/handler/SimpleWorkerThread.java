package com.handler;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Hemant Sharma on 21-01-20.
 * Divergent software labs pvt. ltd
 */
public class SimpleWorkerThread extends Thread {

    private AtomicBoolean alive = new AtomicBoolean(true);
    private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
    private static final String TAG = "SimpleWorkerThread";

    public SimpleWorkerThread(){
        super(TAG);
        start();
    }

    @Override
    public void run() {
        while (alive.get()){
            Runnable task = queue.poll();
            if (task!=null){
                task.run();
            }
        }
    }

    public SimpleWorkerThread execute(Runnable task){
        queue.add(task);
        return this;
    }

    public void quite(){
        alive.set(false);
    }
}
