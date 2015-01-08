<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
	<a href='<spring:url value="/compte/virementMultiple" htmlEscape="true"/>'>effectuer un virement multiple</a><br />
	<a href='<spring:url value="/compte/virementMultipleListe" htmlEscape="true"/>'>consulter la liste des virement multiple</a>
</html>