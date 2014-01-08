package com.mycompany.osgi.demo.channel;

/**
 * @author bandesz
 */
public class ChannelFactory
{

    public Channel createChannel()
    {
        return new Channel(System.currentTimeMillis());
    }

}
