<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>Consultation et signature</title>

<%-- 		<link rel="stylesheet" type="text/css" href='<c:url value="/ressources/ext-all.css"/>'/> --%>
<link rel="stylesheet" type="text/css" href='http://cdn.sencha.com/ext/gpl/4.1.1/resources/css/ext-all.css' />
		<script type="text/javascript" src='<c:url value="/ressources/ext-base.js"/>'></script>

<%-- 		<script type="text/javascript" src='<c:url value="/ressources/ext-all-debug.js" />'></script> --%>
<script type="text/javascript" src='http://cdn.sencha.com/ext/gpl/4.1.1/ext-all-debug.js'></script>
		<script type="text/javascript" src='<c:url value="/extjs/ext-lang-fr.js"/>'></script>
		
		<link rel="stylesheet" type="text/css" href='<c:url value="/ressources/examples.css"/>'> 
		
		<link rel="stylesheet" type="text/css" href='<c:url value="/ressources/virtualkeyboard.css"/>'>
		<script type="text/javascript" src='<c:url value="/ressources/Ext.ux.VirtualKeyboard.js"/>'></script>
		<script type="text/javascript" src='<c:url value="/ressources/Ext.ux.plugins.VirtualKeyboard.js"/>'></script>
		<script type="text/javascript" src='<c:url value="/ressources/virtualkeyboard.js"/>'></script>

	</head>

</head>
<body>

<header>
	<a href='<spring:url value="/logout" />'>Se Déconnecter</a><br />

	<h1>Consultation et signature du demande</h1>
</header>
<c:if test="${ErrorExist}">

</c:if>

<c:choose>
      <c:when test="${ErrorExist}">
      <h1>${Error}</h1>
      <br />
      </c:when>

      <c:otherwise>
      
      
		<h3>Bonjour Monsieur : ${nomAbonne}</h3>
		Votre virement est prévu d'étre exécuté le : <c:out value="${virement.dateExecution}" /> après votre signature
		par le compte : <c:out value="${virement.compte.intitule}" /> 
		le montant du virement : <c:out value="${virement.montant}" /> 
		
		<h1>La liste des bénéficiaire de ce virement</h1>
		
		<table border="1px solide">
			<thead>
				<th>Id</th>
				<th>Nom & Prénom</th>
				<th>Numéro compte</th>
				<th>Monatn</th>
			</thead>
			<tbody>
				<c:forEach var="listBeneficiaire" items="${listBeneficiaire}">
	
					<tr>
						<td><c:out value="${listBeneficiaire.idBeneficiaire}" /></td>
						<td><c:out value="${listBeneficiaire.fullName}" /></td>
						<td><c:out value="${listBeneficiaire.numeroCompte}" /></td>
						<td><c:out value="${listBeneficiaire.montant}" /></td>
					</tr>
	
				</c:forEach>
			</tbody>
		</table>
		
		
		<h1>Merci de confirmer la validation du virement par votre mot de passe</h1>
		
		<div id="virtualkeyboard-form"></div>

      </c:otherwise>
</c:choose>


</body>
</html>