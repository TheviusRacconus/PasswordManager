package com.theviusracconus.passwordmanager.user;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.theviusracconus.passwordmanager.reference.Reference;
import com.theviusracconus.passwordmanager.reference.ServerCommunication;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CurrentUser
{
    public static List<Site> sites = new ArrayList<Site>();
    public static int userId;
    public static String username = "";
     
    //save list to file
    public static void updateSites()
    {
        JSONArray data = new JSONArray();
        
        data.add(userId);
        
        for(Site s : sites)
        {
            //add the json object for the site to the list
            data.add(constructJSON(s));
        }
        
        ServerCommunication.send("updatesites", data.toJSONString());
    }
    
    public static boolean readSites()
    {
        String response = ServerCommunication.send("getsites", "" + userId);
        String siteName, username, password;
        
        if(response.equals("error\n"))
        {
            return false;
        }
        else
        {
            try
            {
                JSONParser parser = new JSONParser();
                JSONArray list = (JSONArray) parser.parse(response);
                for(Object obj : list)
                {
                    JSONObject json = (JSONObject) obj;
                    siteName = (String) json.get("siteName");
                    username = (String) json.get("username");
                    password = (String) json.get("password");
                    sites.add(new Site(siteName, username, password));
                }
                return true;
            }
            catch (ParseException ex) 
            {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    public static void addSite(Site s)
    {
        sites.add(s);
        updateSites();
    }
    
    public static void removeSites(int[] indices)
    {
        for(int i = indices.length - 1; i >= 0; i--)
        {
            sites.remove(indices[i]);
        }
        updateSites();
    }
    
    //get an array of the site names
    public static String[] getSites()
    {
        String[] result = new String[sites.size()];
        String current;
        for(int i = 0; i < sites.size(); i++)
        {
            current = sites.get(i).getSiteName();
            
            if(current.length() > 4 && current.substring(0, 4).equals("www."))
            {
                current = current.substring(4);
            }
            if(current.length() > 4 && 
                    current.substring(current.lastIndexOf(".")).equals(".com"))
            {
                current = current.substring(0, current.lastIndexOf("."));
            }
            
            result[i] = current + " -- " + sites.get(i).getUsername();
        }
        
        return result;
    }
    
    public static Site getSite(int index)
    {
        return sites.get(index);
    }
    
    private static JSONObject constructJSON(Site s)
    {
        JSONObject json = new JSONObject();
        json.put("siteName", s.getSiteName());
        json.put("username", s.getUsername());
        json.put("password", s.getPassword());
        return json;
    }
    
}
