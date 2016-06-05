package com.theviusracconus.passwordmanager.reference;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Reference 
{
    public static final String BASE_PATH = System.getProperty("user.dir") + "\\files\\";
    public static final String SERVER_PATH = "http://localhost/PasswordManager/";
    
    public static String filePath(String name)
    {
        return BASE_PATH + name;
    }
    
    
    public static String pwString(char[] pw)
    {
        String pwStr = "";
        
        for(char c : pw)
        {
            pwStr += c;
        }
        
        return pwStr;
    }
    
    public static void copy(String str)
    {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = defaultToolkit.getSystemClipboard();
        clipboard.setContents(new StringSelection(str), null);
    }
    
    public static boolean validUrl(String url)
    {
        if(url.indexOf("www.") == 0)
        {
            url = url.substring(4);
        }
        
        return url.lastIndexOf(".") > 0 && url.lastIndexOf(".") < url.length() - 1;
    }
    
}
