package com.mycompany.osgi.demo.bundle1;

import com.mycompany.osgi.demo.api.api1.Api1;
import com.mycompany.osgi.demo.bundle1.impl.ApiImplementation;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator extends DependencyActivatorBase implements BundleActivator
{
    @Override
    public void init(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] started");

        manager.add(createComponent()
                .setInterface(Api1.class.getName(), null)
                .setImplementation(ApiImplementation.class));
    }

    @Override
    public void destroy(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] stopped");
    }

}
