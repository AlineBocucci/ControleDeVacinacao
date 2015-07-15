<%-- 
    Document   : indexMarca
    Created on : 27/11/2014, 23:40:24
    Author     : Misael
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><fmt:message key="titulo.listamarca"/></h1>        
        <table border="1">
            <thead>
            <th><fmt:message key="campo.nome"/></th>
            <th><fmt:message key="campo.editar"/></th>
            <th><fmt:message key="campo.deletar"/></th>
        </thead>
        <c:forEach var="marca" items="${marcas}">
            <tr>
                <td>${marca.nome}</td>
                <td><a href="marcasController?idEditar=${marca.id}"><fmt:message key="botao.editar"/></a></td>
                <td><a href="marcasController?idDelete=${marca.id}"><fmt:message key="botao.apagar"/></a></td>
            </tr>           
        </c:forEach>
    </table>
    <a href="<c:url value="/"/>marcasController?idEditar=0"><fmt:message key="botao.novo"/></a>       
    <a href="admin/menu.jsp"><fmt:message key="campo.voltar"/></a>
    <img src="imagens/ze_gotinha-2.jpg" align="right">
    



</body>
</html>
