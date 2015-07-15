

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Vacina"%>
<%@page contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista das Vacinas</title>
    </head>
    <body>
        <h1><fmt:message key="titulo.editarvacina"/></h1>
        <h1><fmt:message key="titulo.lista"/></h1>        
        <table border="1">
            <thead>
            <th><fmt:message key="campo.id"/></th>
            <th><fmt:message key="campo.nome_vacina"/></th>
            <th><fmt:message key="campo.dosagem"/></th>
            <th><fmt:message key="campo.info_vacina"/></th>
            <th><fmt:message key="campo.editar"/></th>
            <th><fmt:message key="campo.deletar"/></th>
            </thead>
            <c:forEach var="vacina" items="${vacinas}">
            <tr>
                <td>${vacina.id}</td>
                <td>${vacina.nome_vacina}</td>                
                <td>${vacina.dosagem}</td>
                <td>${vacina.info_vacina}</td>
                <td><a href="VacinasController?idEditar=${vacina.id}"><fmt:message key="botao.editar"/></a></td>
                <td><a href="VacinasController?idDelete=${vacina.id}"><fmt:message key="botao.apagar"/></a></td>
            </tr>           
            </c:forEach>
        </table>
        <a href="<c:url value="/"/>/VacinasController?idEditar=0"><fmt:message key="botao.novo"/></a>
        <a href="admin/menu.jsp"><fmt:message key="campo.voltar"/></a>
        <img src="imagens/ze_gotinha-2.jpg" align="right">
    </body>
</html>
