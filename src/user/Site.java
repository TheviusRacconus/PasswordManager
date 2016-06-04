package user;

import java.io.Serializable;

public class Site implements Serializable
{
    private String siteName, username, password;
    
    public Site(String sName, String uName, String pWord)
    {
        siteName = sName;
        username = uName;
        password = pWord;
    }
    
    public String getSiteName()
    {
        return siteName;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setSiteName(String sName)
    {
        siteName = sName;
    }
    
    public void setUsername(String uName)
    {
        username = uName;
    }
    
    public void setPassword(String pWord)
    {
        password = pWord;
    }
}
