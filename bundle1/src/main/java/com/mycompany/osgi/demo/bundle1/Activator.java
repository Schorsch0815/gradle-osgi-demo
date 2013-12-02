package com.mycompany.osgi.demo.bundle1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author bandesz
 */
public class Activator implements BundleActivator
{
    @Override
    public void start(final BundleContext bundleContext) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] started");
    }

    @Override
    public void stop(final BundleContext bundleContext) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] stopped");
    }
}
