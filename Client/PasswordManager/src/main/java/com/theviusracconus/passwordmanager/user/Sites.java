package com.theviusracconus.passwordmanager.user;

import com.theviusracconus.passwordmanager.user.Site;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

public class Sites implements Serializable
{
    private List<Site> sites;
    
    public Sites()
    {
        sites = new ArrayList<Site>();
    }
    
    public void addSite(Site s)
    {
        sites.add(s);
        CurrentUser.updateSites();
    }
    
    public void removeSites(int[] indices)
    {
        for(int i = indices.length - 1; i >= 0; i--)
        {
            sites.remove(indices[i]);
        }
        CurrentUser.updateSites();
    }
    
    //get an array of the site names
    public String[] getSites()
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
    
    public Site getSite(int index)
    {
        return sites.get(index);
    }
    
}
