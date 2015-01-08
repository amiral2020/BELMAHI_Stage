<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:url value='j_spring_security_check' /> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>My App web</title>
<!-- ExtJS import -->
<!-- <link rel="stylesheet" type="text/css" href="extjs/ext-all.css" /> -->
<link rel="stylesheet" type="text/css" href='http://cdn.sencha.com/ext/gpl/4.1.1/resources/css/ext-all.css' />
<!-- <script type="text/javascript" src="extjs/ext-all-debug.js"></script> -->
<script type="text/javascript" src='http://cdn.sencha.com/ext/gpl/4.1.1/ext-all-debug.js'></script>
<script type="text/javascript" src=<spring:url value="/extjs/ext-lang-fr.js" htmlEscape="true"/>></script>

<!-- Our script -->
<script type="text/javascript" src="app/view/Login.js"></script>
<script type="text/javascript" src="app/controller/LoginController.js"></script>
<script type="text/javascript" src="app.js"></script>
<!-- <script type="text/javascript" src="array-grid.js"></script> -->
</head>
<body>

<div id="grid-example">
</div>

</body>
</html>