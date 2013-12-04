package com.mycompany.osgi.demo.bundle2;

import com.mycompany.osgi.demo.api.api1.IMedia;

/**
 * @author bandesz
 */
public class Media implements IMedia
{
    private int version = 3;

    @Override
    public int getVersion()
    {
        return version;
    }

    public String toString()
    {
        return getName();
    }

    public String getName()
    {
        return "media(ver: " + version + ")";
    }
}
