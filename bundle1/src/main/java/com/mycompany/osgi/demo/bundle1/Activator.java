package com.mycompany.osgi.demo.bundle1;

import com.mycompany.osgi.demo.api.api1.Api1;
import com.mycompany.osgi.demo.bundle1.impl.ApiImplementation;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ManagedService;

import java.util.Dictionary;
import java.util.Hashtable;

public class Activator extends DependencyActivatorBase implements BundleActivator
{
    @Override
    public void init(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] started");

        Dictionary props = new Hashtable();
        props.put("service.pid", ApiImplementation.class.getCanonicalName());

        String interfaces[] = { Api1.class.getName(), ManagedService.class.getName() };

        manager.add(createComponent()
                .setInterface(interfaces, props)
                .setImplementation(ApiImplementation.class));
    }

    @Override
    public void destroy(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] stopped");
    }

}
