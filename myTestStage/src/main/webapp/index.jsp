<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>my Test</title>
</head>
<body>
	
	<header>
		<h1>Welcome</h1>
	</header>
	<a href='<spring:url value="/login" />'>Se connecter</a><br />

</body>
</html>