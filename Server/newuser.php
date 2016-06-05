<?php
include "functions.php";

$data = json_decode($_POST["data"], true);
$username = $data["username"];
$password = $data["password"];

$password_hash = password_hash($password, PASSWORD_BCRYPT);

$db = connect();

$sql = "INSERT INTO tr7_user (username,password)
        VALUES ('$username','$password_hash')";

if(mysqli_query($db, $sql))
{
    $sql = "SELECT user_id 
            FROM tr7_user
            WHERE username='$username'";
    
    $result = mysqli_query($db, $sql);
    if($result && mysqli_num_rows($result) > 0)
    {
        $row = mysqli_fetch_assoc($result);
        $user_id = $row["user_id"];
        echo "$user_id";
    }
    else
    {
        echo "failure";
    }
}
else
{
    echo "failure";
}
?>