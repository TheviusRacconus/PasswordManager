
package com.theviusracconus.passwordmanager.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ServerCommunication 
{
    public static String send(String page, String data, String key)
    {
        try
        {
            String toSend = key + "=" + data;
            URL url = new URL(Reference.SERVER_PATH + page + ".php");
            URLConnection con = url.openConnection();
            
            con.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(toSend);
            wr.flush();
            
            con.getInputStream();
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line, result = "";
            while((line = rd.readLine()) != null)
            {
                result += line + "\n";
            }
            
            System.out.println(result);
            
            wr.close();
            rd.close();
            
            return result;
        } 
        catch (MalformedURLException ex) 
        {
            ex.printStackTrace();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static String send(String page, String data)
    {
        return send(page, data, "data");
    } 
}