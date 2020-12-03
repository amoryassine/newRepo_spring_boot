<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Ajouter Voiture</title>
</head>
<body>
<div class="container">
<div class="card-body">
<form action="saveVoiture" method="POST">
<div class="form-group">
<label class="control-label">Marque voiture :</label>
<input type="text" name="marque" class="form-control"/>
</div>

<div class="form-group">
<label class="control-label">modele voiture :</label>
<input type="text" name="modele" class="form-control"/>
</div>




<div class="form-group">
<label class="control-label">immatriculation voiture :</label>
<input type="text" name="immatriculation" class="form-control"/>
</div>


<div class="form-group">
<label class="control-label">couleur Voiture :</label>
<input type="text" name="couleur" class="form-control"/>
</div>

<div class="form-group">
<label class="control-label">puissance fiscale Voiture :</label>
<input type="text" name="puissance_fiscale" class="form-control"/>
</div>

<div class="form-group">
<label class="control-label">prix par heure :</label>
<input type="text" name="prix_par_heure" class="form-control"/>
</div>


<div class="form-group">
<label class="control-label">date creation voiture :</label>
<input type="date" name="date_creation_voiture" class="form-control"/>
</div>
<div>
<button type="submit" class="btn btn-primary">Save</button>
</div>
</form>
</div>
${msg}
<br/>
<br/>
<a href="listeVoiture">Liste Voiture</a>
</div>
</body>
</html>