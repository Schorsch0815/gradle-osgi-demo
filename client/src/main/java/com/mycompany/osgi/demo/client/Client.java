package com.mycompany.osgi.demo.client;

import com.mycompany.osgi.demo.channel.Channel;
import com.mycompany.osgi.demo.channel.ChannelFactory;
import com.mycompany.osgi.demo.stat.Stat;

/**
 * @author bandesz
 */
public class Client implements Runnable
{

    private volatile ChannelFactory channelFactory;

    private volatile Stat stat;

    private boolean running = false;

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
        long time = System.currentTimeMillis();
        boolean hasToWait = channelFactory != null;
        while (running)
        {
            if (channelFactory == null) {
                hasToWait = true;
                continue;
            } else if (hasToWait) {
                hasToWait = false;
                stat.reportWaitTime(System.currentTimeMillis() - time);
                time = System.currentTimeMillis();
            }
            Channel channel = channelFactory.createChannel();
            stat.channelCreated(channel.version);
        }
    }
}
