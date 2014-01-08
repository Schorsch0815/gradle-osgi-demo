package com.mycompany.osgi.demo.channel;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;
import java.util.Hashtable;

public class Activator extends DependencyActivatorBase
{

    @Override
    public void init(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(context.getBundle().getSymbolicName() + " started");

        Dictionary props = new Hashtable();
        props.put("service.pid", ChannelFactory.class.getCanonicalName());

        manager.add(createComponent()
                .setInterface(ChannelFactory.class.getCanonicalName(), props)
                .setImplementation(ChannelFactory.class));
    }

    @Override
    public void destroy(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(context.getBundle().getSymbolicName() + " stopped");
    }
}
