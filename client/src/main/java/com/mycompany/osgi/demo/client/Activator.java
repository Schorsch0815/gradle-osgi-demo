package com.mycompany.osgi.demo.client;

import com.mycompany.osgi.demo.channel.ChannelFactory;
import com.mycompany.osgi.demo.stat.Stat;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;
import java.util.Hashtable;

public class Activator extends DependencyActivatorBase
{

    private Client client;

    @Override
    public void init(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(context.getBundle().getSymbolicName() + " started");

        Dictionary props = new Hashtable();
        props.put("service.pid", Client.class.getCanonicalName());

        client = new Client();

        manager.add(createComponent()
                .setInterface(Object.class.getName(), props)
                .setImplementation(client)
                .add(createServiceDependency().setService(ChannelFactory.class).setRequired(false))
                .add(createServiceDependency().setService(Stat.class).setRequired(true))
        );
    }

    @Override
    public void destroy(final BundleContext context, final DependencyManager manager) throws Exception
    {
        client = null;

        System.out.println(context.getBundle().getSymbolicName() + " stopped");
    }
}
