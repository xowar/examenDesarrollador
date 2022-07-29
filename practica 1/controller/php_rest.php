<?php
    //Obtiene los datos del json y los tranformamos a String
    $url = "https://my-json-server.typicode.com/dp-danielortiz/dptest_jsonplaceholder/items";
    $data= file_get_contents($url);
        $obj = json_decode($data, true); 

        //Obtenemos la cantidad de resultados
        $res = count($obj);

        //Buscamos los resultados que sean diferentes de green
        //para procerder a eliminarlos
        for ($i=0; $i < $res ; $i++) { 
            if ($obj[$i]["color"] != 'green') {
                unset($obj[$i]);            
            }
        }

        //Cambiamos a formato Json
        $obj = json_encode($obj);

        //Imprime en consola los datos obtenidos.
        $console = 'console.log('.$obj.');';
        echo "<script>console.log('".$console."' );</script>";

        //Crea un archivo con el nombre Respuesta1.json
        return file_put_contents("Respuesta1.json", $obj); 
?>