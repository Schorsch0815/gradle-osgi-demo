package com.mycompany.osgi.demo.stat;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;
import java.util.Hashtable;

public class Activator extends DependencyActivatorBase
{
    Stat stat;

    @Override
    public void init(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(context.getBundle().getSymbolicName() + " started");

        Dictionary props = new Hashtable();
        props.put("service.pid", Stat.class.getCanonicalName());

        stat = new Stat();

        manager.add(createComponent()
                .setInterface(Stat.class.getName(), props)
                .setImplementation(stat)
        );
    }

    @Override
    public void destroy(final BundleContext context, final DependencyManager manager) throws Exception
    {
        stat = null;

        System.out.println(context.getBundle().getSymbolicName() + " stopped");
    }
}
