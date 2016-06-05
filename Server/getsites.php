<?php
$user_id = $_POST["data"];

if($file = fopen("files/$user_id.json", "r"))
{
    echo fread($file, filesize("files/$user_id.json"));
}
else
{
    echo "error";
}
?>