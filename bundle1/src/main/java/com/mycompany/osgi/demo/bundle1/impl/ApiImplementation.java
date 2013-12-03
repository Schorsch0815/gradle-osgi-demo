package com.mycompany.osgi.demo.bundle1.impl;

import com.mycompany.osgi.demo.api.api1.Api1;

public class ApiImplementation implements Api1
{

    @Override
    public String doSomething(final String input)
    {
        return "Called " + getClass().getCanonicalName() + ".call()" + " with " + input;
    }
}
