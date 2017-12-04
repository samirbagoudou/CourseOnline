<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Inscription page</title>
	</head>
	<body>
	<form action="../inscription" method="POST">
	<input type="hidden" name="sessionId" value="${sessionId}">
	<input name="firstName" value="Joe">
	<input name="lastName" value="Jerry">
	<input name="address" value="11 Avenue Belfort">
	<input name="phone" value="15840025">
	<input name="email" value="foo@bar.com">
	<input type="submit" value="submit">
	</form>
	</body>
</html>