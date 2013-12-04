package com.mycompany.osgi.demo.bundle2;

import com.mycompany.osgi.demo.api.api1.Api1;

/**
 * @author bandesz
 */
public class Service2 implements Runnable
{

    private volatile Api1 api;

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
