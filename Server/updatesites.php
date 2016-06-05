<?php
$data = json_decode($_POST["data"]);
$user_id = $data[0];

$site_list = array();

if(count($data) > 1)
{
    for($i = 1; $i < count($data); $i++)
    {
        $site_list[$i - 1] = $data[$i];
    }
}

$sites_json = json_encode($site_list);
$file = fopen("files/$user_id.json", "w");
fwrite($file, $sites_json);
fclose($file);
?>