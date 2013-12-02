package tv.ustream.osgi.demo.bundle2;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import tv.ustream.osgi.demo.bundle1.api.Api;

/**
 * @author bandesz
 */
public class Activator implements BundleActivator
{
    @Override
    public void start(final BundleContext bundleContext) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] started");
        Api api = new Api();
        System.out.println(api.call("hello"));
    }

    @Override
    public void stop(final BundleContext bundleContext) throws Exception
    {
        System.out.println(getClass().getCanonicalName() + " [" + hashCode() + "] stopped");
    }
}
