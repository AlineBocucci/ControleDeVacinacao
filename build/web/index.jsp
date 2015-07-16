<<<<<<< HEAD

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="campo.titulo"/></title>
    </head>
    <body>
        <div>
            <a href="<c:url value="/Idioma?idioma=pt&pais=br"/>"><fmt:message key="campo.portugues"/></a> || 
            <a href="<c:url value="/Idioma?idioma=en&pais=us"/>"><fmt:message key="campo.ingles"/></a><br><br>
        </div>
        <div align="center">
            <h1 align="center"><fmt:message key="campo.titulo"/></h1>
            <a href="login.jsp">Login</a><br><br>
            <img src="imagens/ze_gotinha-1.jpg" align="center">
        </div>
    </body>
=======

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="campo.titulo"/></title>
    </head>
    <body>
        <div>
            <a href="<c:url value="/Idioma?idioma=pt&pais=br"/>"><fmt:message key="campo.portugues"/></a> || 
            <a href="<c:url value="/Idioma?idioma=en&pais=us"/>"><fmt:message key="campo.ingles"/></a><br><br>
        </div>
        <div align="center">
            <h1 align="center"><fmt:message key="campo.titulo"/></h1>
            <a href="login.jsp">Login</a><br><br>
            <img src="imagens/ze_gotinha-1.jpg" align="center">
        </div>
    </body>
>>>>>>> origin/master
</html>