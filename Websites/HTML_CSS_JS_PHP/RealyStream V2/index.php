<!DOCTYPE html>
<html>
	<head>
		<title> Accueil - realystream.ml</title>

		<!-- Icone -->
		<link rel="icon" type="image/x-icon" href="img/favicon.ico">

		<!-- Font -->
		<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600" rel="stylesheet">

		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
	</head>

	<!-- Contenu du site -->

	<body>
		<!-- Header -->
		<header class="container-fluid header">
			<div class="container">
				<h3 class="titre">RealyStream</h3>
				<nav class="menu">
					<a href="#"> Accueil </a>
				</nav>
			</div>
		</header>

		<!-- Bannière -->
		<section class="container-fluid banner">
			<div class="ban">
				<img src="img/ban.png" alt="Bannière de RealyStream.">
			</div>
			<div class="inner-banner">
				<h1>RealyStream le meilleur site pour les Streameurs !</h1>
				<a class="btn btn-custom" href="inscription.php" target="_BLANK">C'est Parti pour le stream !</a>
			</div>

		<!-- Compteurs -->
		<section class="container-fluid compteurs">
			<div class="container">
				<h2 id="Le site à été visité"></h2>
				<hr class="separator">
				<article class="col-md-3 col-lg-3 col-xs-12 col-sm-12 item-folio">
					<center>
						<?php
 
						$ip = fopen('last_ip.txt', 'c+');
						$check = fgets($ip);
						 
						$file = fopen('counter.txt', 'c+');
						$count = intval(fgets($file));
						 
						if($_SERVER['REMOTE_ADDR'] != $check)
						{
						    fclose($ip);
						   
						    $ip = fopen('last_ip.txt', 'w+');
						   
						    fputs($ip, $_SERVER['REMOTE_ADDR']);
						   
						    $count++;
						    fseek($file, 0);
						    fputs($file, $count);
						}
						 
						fclose($file);
						fclose($ip);
						 
						echo $count;

						?>
					</center>
				</article>
			</div>
		</section>

		</section>

	</body>
</html>