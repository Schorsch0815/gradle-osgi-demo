package tv.ustream.osgi.demo.bundle1.api;

/**
 * @author bandesz
 */
public class Api
{

    public String call(final String input)
    {
        return "Called " + getClass().getCanonicalName() + ".call()" + " with " + input;
    }

}
