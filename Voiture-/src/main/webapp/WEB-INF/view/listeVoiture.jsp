<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Voiture</title>
</head>

<body>
<div class="container">
<div class="card">
<div class="card-header">
Liste des Voiture
</div>
<div class="card-body">
<table class="table table-striped">
<tr>
<th>ID</th><th>marque Voiture</th><th>modele Voiture</th><th>immatriculation Voiture</th><th>couleur Voiture</th><th>puissance fiscale Voiture</th><th>prix par heure</th><th>Date Création voiture</th><th>Suppression<th>Edition</th>
</tr>
<c:forEach items="${voiture}" var="v">
<tr>
<td>${v.idvoiture }</td>
<td>${v.marque }</td>
<td>${v.modele }</td>
<td>${v.immatriculation }</td>
<td>${v.couleur }</td>
<td>${v.puissance_fiscale }</td>
<td>${v.prix_par_heure}</td>

<td><fmt:formatDate pattern="dd/MM/yyyy" value="${v.date_creation_voiture}" /></td>
<td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerVoiture?id=${v.idvoiture }">Supprimer</a></td>
<td><a href="modifierVoiture?id=${v.idvoiture }">Edit</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</body>
</html>