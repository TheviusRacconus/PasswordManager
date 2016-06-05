<?php
function connect()
{
    //connect to database
    $host = "localhost";
    $username = "thevius";
    $db_password = "QCeQfeTQuxjPaCfF";
    $db_name = "password_manager";
    
    $db = mysqli_connect($host, $username, $db_password, $db_name);
        
    if(!$db)
    {
        echo "Could not connect to database";
        exit;    
    }
        
    else
    {
        return $db;
    }
}
?>