package com.mycompany.osgi.demo.bundle2;

import com.mycompany.osgi.demo.api.api1.Api1;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

public class Activator extends DependencyActivatorBase
{

    @Override
    public void init(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] started");

        manager.add(createComponent()
                .setInterface(Object.class.getName(), null)
                .setImplementation(Service2.class)
                .add(createServiceDependency().setService(Api1.class).setRequired(true)));
    }

    @Override
    public void destroy(final BundleContext context, final DependencyManager manager) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] stopped");
    }

}
