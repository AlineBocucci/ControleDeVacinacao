<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1><fmt:message key="campo.erro"/></h1>
        <%=((Exception) request.getAttribute("erro")).getMessage()%>
        <img src="imagens/ze_gotinha-2.jpg" align="right">

    </body>
</html>
