package user;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import reference.Reference;

public class UserList
{
    public static List<User> users;
    public static User currentUser;
    
    public static void initList()
    {
        //set current user to a placeholder
        currentUser = new User("","");
        
        //make sure folders in file path exist
        generateFolders();
        
        //attempt to deserialize user list from file
        //if unsuccessful, initialize users to an empty list
        if(!deserialize())
        {
            users = new ArrayList<User>();
        }
    }
    
    public static void add(User u)
    {
        users.add(u);
        serialize();
    }
    
    public static boolean generateFolders()
    {
        return new File(Reference.BASE_PATH).mkdirs();
    }
    
    public static boolean userExists(String username)
    {
        for(User u : users)
        {
            if(username.equals(u.getUsername()))
            {
                return true;
            }
        }
        
        return false;
    }
    
    //save list to file
    public static boolean serialize()
    {
        String path = Reference.filePath("users.ser");
        boolean successful = false;
        
        try
        {
            FileOutputStream output = new FileOutputStream(path);
            ObjectOutputStream objOut = new ObjectOutputStream(output);
            objOut.writeObject(users);
            objOut.close();
            output.close();
            successful = true;
        } 
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        
        return successful;
    }
    
    //read list from file
    public static boolean deserialize()
    {
        String path = Reference.filePath("users.ser");
        boolean successful = false;
        
        try
        {
            FileInputStream input = new FileInputStream(path);
            ObjectInputStream objIn = new ObjectInputStream(input);
            users = (List<User>) objIn.readObject();
            objIn.close();
            input.close();
            
            for(User u: users)
            { 
                if(u.isRemembered())
                {
                    currentUser = u;
                }
            }
            
            successful = true;
        } 
        catch (IOException | ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        
        return successful;
    }
}
