package user;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable
{
    //Instance fields
    private String username;
    private byte[] password, salt;
    private List<Site> sites;
    private boolean remembered;
    private transient PasswordEncryption encryption;
    
    public User(String name, String pass)
    {
        encryption = new PasswordEncryption();
        username = name;
        
        //encrypt the password
        try 
        {
            salt = encryption.generateSalt();
            password = encryption.getEncryptedPassword(pass, salt);
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException ex) 
        {
            ex.printStackTrace();
        }
        sites = new ArrayList<Site>();
        remembered = false;
    }
    
    public void addSite(Site s)
    {
        sites.add(s);
        UserList.serialize();
    }
    
    public void removeSites(int[] indices)
    {
        for(int i = indices.length - 1; i >= 0; i--)
        {
            sites.remove(indices[i]);
        }
        UserList.serialize();
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
    
    public String getUsername()
    {
        return username;
    }
    
    public byte[] getPassword()
    {
        return password;
    }
    
    public byte[] getSalt()
    {
        return salt;
    }
    
    public boolean isRemembered()
    {
        return remembered;
    }
    
    public void setRemembered(boolean b)
    {
        remembered = b;
    }
}
