<?php
include "functions.php";

$data = json_decode($_POST["data"], true);
$username = $data["username"];
$password = $data["password"];

$db = connect();

$sql = "SELECT password, user_id 
        FROM tr7_user 
        WHERE username='$username'";

$result = mysqli_query($db, $sql);

if(mysqli_num_rows($result) > 0)
{
    $row = mysqli_fetch_assoc($result);
    $user_id = $row["user_id"];
    $password_hash = $row["password"];
    
    if(password_verify($password, $password_hash))
    {
        echo "$user_id";
    }
    else
    {
        echo "incorrect password";
    }
}
else
{
    echo "not found";
}

?>