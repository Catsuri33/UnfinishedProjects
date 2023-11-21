
<!--Site créer par Catsuri33 tout droit réservé à Catsuri33, Aygame et Aycraft-->

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<style type="text/css"></style>
	<link rel="stylesheet" media="screen" type="text/css" title="index" href="css/index.css" />
	<link rel="icon" type="image/png" href="img/favicon.ico" />
	<title>Aycraft - aycraft.cf</title>
</head>
<body>

	<h1 class="titre">
		<strong>Aycraft</strong>
	</h1>

	<img class="logonuages" src="img/nuages.png">

	<ul id="navigation">
  		<li><a href="index.php" title="Accueil">Accueil</a></li>
  		<li><a href="présentation.php" title="Présentation">Présentation</a></li>
  		<li><a href="grades.php" title="Grades">Grades</a></li>
  		<li><a href="règles.php" title="Règles">Règles</a></li>
  		<li><a href="staff.php" title="Staff">Staff</a></li>
  		<li><a href="forum.php" title="Forum">Forum</a></li>
  		<li><a href="votes.php" title="Votes">Votes</a></li>
  		<li style="float:right"><a href="connexion.php" title="Connexion">Connexion</a></li>
  		<li style="float:right"><a href="#" class="active" title="Inscription">Inscription</a></li>
	</ul>

	<?php
	session_start();
	$titre="Enregistrement";
	include("includes/identifiants.php");
	include("includes/debut.php");
	include("includes/menu.php");
	echo '<p><i>Vous êtes ici</i> : <a href="./index.php">Index du forum</a> --> Enregistrement';

	if ($id!=0) erreur(ERR_IS_CO);
	?>

	<?php
if (empty($_POST['pseudo'])) // Si on la variable est vide, on peut considérer qu'on est sur la page de formulaire
{
	echo '<h1>Inscription 1/2</h1>';
	echo '<form method="post" action="register.php" enctype="multipart/form-data">
	<fieldset><legend>Identifiants</legend>
	<label for="pseudo">* Pseudo :</label>  <input name="pseudo" type="text" id="pseudo" /> (le pseudo doit contenir entre 3 et 15 caractères)<br />
	<label for="password">* Mot de Passe :</label><input type="password" name="password" id="password" /><br />
	<label for="confirm">* Confirmer le mot de passe :</label><input type="password" name="confirm" id="confirm" />
	</fieldset>
	<fieldset><legend>Contacts</legend>
	<label for="email">* Votre adresse Mail :</label><input type="text" name="email" id="email" /><br />
	<label for="msn">Votre adresse MSN :</label><input type="text" name="msn" id="msn" /><br />
	<label for="website">Votre site web :</label><input type="text" name="website" id="website" />
	</fieldset>
	<fieldset><legend>Informations supplémentaires</legend>
	<label for="localisation">Localisation :</label><input type="text" name="localisation" id="localisation" />
	</fieldset>
	<fieldset><legend>Profil sur le forum</legend>
	<label for="avatar">Choisissez votre avatar :</label><input type="file" name="avatar" id="avatar" />(Taille max : 10Ko<br />
	<label for="signature">Signature :</label><textarea cols="40" rows="4" name="signature" id="signature">La signature est limitée à 200 caractères</textarea>
	</fieldset>
	<p>Les champs précédés d un * sont obligatoires</p>
	<p><input type="submit" value="S\'inscrire" /></p></form>
	</div>
	</body>
	</html>';
	
	
} //Fin de la partie formulaire
?>

<?php
else //On est dans le cas traitement
{
    $pseudo_erreur1 = NULL;
    $pseudo_erreur2 = NULL;
    $mdp_erreur = NULL;
    $email_erreur1 = NULL;
    $email_erreur2 = NULL;
    $msn_erreur = NULL;
    $signature_erreur = NULL;
    $avatar_erreur = NULL;
    $avatar_erreur1 = NULL;
    $avatar_erreur2 = NULL;
    $avatar_erreur3 = NULL;
?>



</body>
<footer>
	<p class="footer">Copyright &copy; <strong>Aycraft</strong> 2018 - 2019 All Right Reserved</p>
</footer>
</html>