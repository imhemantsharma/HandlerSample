package com.handler;

import android.os.Handler;

/**
 * Created by Hemant Sharma on 21-01-20.
 * Divergent software labs pvt. ltd
 */
public class HandlerThread extends android.os.HandlerThread {

    private static final String TAG = "WorkerHandlerThread";
    private Handler handler;

    public HandlerThread() {
        super(TAG);
        start();
        handler = new Handler(getLooper());
    }

    public HandlerThread execute(Runnable task){
        handler.post(task);
        return this;
    }

    public void quite(){
        handler.getLooper().quit();
    }

}
