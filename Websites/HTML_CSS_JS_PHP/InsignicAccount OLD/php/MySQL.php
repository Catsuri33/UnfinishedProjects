<?php


class MySQL {

    private $host = 'localhost';
    private $database = 'insignic';
    private $user = 'root';
    private $password = 'password';
    private $connection;

    function __construct($host = null, $name = null, $user = null, $password = null){

        if($host != null){

            $this->host = $host;
            $this->name = name;
            $this->user = $user;
            $this->password = $password;

        }

        try {

            $this->connection = new PDO('mysql:host='.$this->host.';dbname='.$this->name, $this->user, $this->password, array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES UTF8MB4', PDO::ATTR_ERRMODE => PDO::ERRMODE_WARNING));

        } catch(PDOException $e){

            echo 'Error, cannot connect to the database !';
            die();

        }

    }

    public function connection(){

        return $this->connection;

    }

}

$MYSQL = new MySQL();
$BDD = $MYSQL->connection();

?>