package com.mycompany.osgi.demo.bundle1.impl;

import com.mycompany.osgi.demo.api.api1.Api1;
import com.mycompany.osgi.demo.api.api1.IMedia;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class ApiImplementation implements Api1, ManagedService
{

    private List<IMedia> mediaList = new ArrayList<IMedia>();

    @Override
    public String doSomething(final String input)
    {
        return "Called " + getClass().getCanonicalName() + ".call()" + " with " + input;
    }

    @Override
    public void addMedia(final IMedia media)
    {
        mediaList.add(media);
        System.out.println("Current media list: " + mediaList);
    }

    @Override
    public void updated(final Dictionary properties) throws ConfigurationException
    {
        System.out.println(getClass() + " config was updated: " + properties);
    }
}
