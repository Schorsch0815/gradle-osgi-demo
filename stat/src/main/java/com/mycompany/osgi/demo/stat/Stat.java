package com.mycompany.osgi.demo.stat;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author bandesz
 */
public class Stat implements Runnable
{

    private boolean running = false;

    private int lastChannelVersion = 0;

    private AtomicLong channelCount = new AtomicLong(0);

    private AtomicLong waitTime = new AtomicLong(0);

    public void start()
    {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop()
    {
        running = false;
    }

    @Override
    public void run()
    {
        while (running)
        {
            System.out.format(
                    "Channels created: %d, last version was %d, waittime: %d ms\n",
                    channelCount.get(),
                    lastChannelVersion,
                    waitTime.get()
            );
            channelCount.set(0);
            waitTime.set(0);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void channelCreated(int channelVersion)
    {
        channelCount.incrementAndGet();
        lastChannelVersion = channelVersion;
    }

    public void reportWaitTime(long waitTime)
    {
        this.waitTime.addAndGet(waitTime);
    }
}
