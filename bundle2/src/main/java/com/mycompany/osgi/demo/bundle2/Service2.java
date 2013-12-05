package com.mycompany.osgi.demo.bundle2;

import com.mycompany.osgi.demo.api.api1.Api1;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * @author bandesz
 */
public class Service2 implements Runnable
{

    private volatile Api1 api;

    private volatile ConfigurationAdmin configurationAdmin;

    public Service2()
    {
        new Thread(this).start();
    }

    @Override
    public void run()
    {
        while (true) {
            try
            {
                if (api != null) {
                    System.out.println(api.doSomething("hello"));
                    api.addMedia(new Media());

                    try
                    {
                        Configuration config = configurationAdmin.getConfiguration("com.mycompany.osgi.demo.bundle1.impl.ApiImplementation");
                        Dictionary props = config.getProperties();
                        if (props == null) {
                            props = new Hashtable();
                        }
                        props.put("someKey", String.valueOf(hashCode()));
                        config.update(props);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    break;
                }
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
