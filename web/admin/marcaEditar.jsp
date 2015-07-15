

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Marca</title>
    </head>
    <body>
        <h1><fmt:message key="campo.titulomarca"/></h1>
        <form action="<c:url value="/marcasController"/>" method="post">
              <table>
                <c:if test="${!empty marca.id}">
                <tr>
                    <td><fmt:message key="campo.id"/>:</td>
                    <td><input type="text" value="${marca.id}" name="id" size="10" readonly    /></td>
                </tr>
                </c:if>
                <tr>
                    <td>* <fmt:message key="campo.nome"/>:</td>
                    <td><input type="text" value="${marca.nome}" name="nome" size="100"/></td>
                </tr>
                </table>
            <input type="submit" value="<fmt:message key="botao.enviar"/>"/>
            <a href="<c:url value="/marcasController"/>"><fmt:message key="botao.voltar"/></a>
            
            <c:if test="${!empty erro}">
                <div style="color: red;">
                    ${erro}
                </div>
            </c:if>
        </form>
            <img src="imagens/ze_gotinha-2.jpg" align="right">
    </body>
</html>
