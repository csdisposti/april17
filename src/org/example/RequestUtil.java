package org.example;
import java.io.InputStream;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Created by mrkirkland on 3/20/2017.
 */
public class RequestUtil {
    /*
        returns a list of the request body's equalities if there is any, otherwise returns null
     */
    public static HashMap<String, String> getRequestProp(InputStream is)
    {
        HashMap<String, String> x = new HashMap(1);

        Scanner s = new Scanner(is).useDelimiter("&");
        if (s.hasNext())
        {
            while (s.hasNext())
            {
                String str;
                str = s.next();
                //System.out.println(str.substring(0, str.indexOf("=")));
                //System.out.println(str.substring(str.indexOf("=")+1,str.length()));
                x.put(str.substring(0,str.indexOf("=")),str.substring(str.indexOf("=")+1,str.length()));
            }
        }
        else
        {
            return null;
        }
        return x;
    }
}
