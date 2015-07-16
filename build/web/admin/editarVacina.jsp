<<<<<<< HEAD

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Vacina"%>
<%@page contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <h1> <fmt:message key="titulo.editarvacina"/></h1>
        <form action="<c:url value="/VacinasController"/>" method="post">
            <table>
                <c:if test="${!empty vacina.id}">    
                    <tr>
                        <td><fmt:message key="campo.id"/>:</td>
                        <td><input type="text" value="${vacina.id}" name="id" size="10" readonly    /></td>
                    </tr>
                </c:if>
                <tr>
                    <td>* <fmt:message key="campo.nome"/>:</td>
                    <td><input type="text" value="${vacina.nome_vacina}" name="nome_vacina" size="100"/></td>
                </tr>

                <tr>
                    <td><fmt:message key="campo.descricao"/>:</td>
                    <td><textarea name="info_vacina" cols="80" rows="5">${vacina.info_vacina}</textarea></td>
                </tr>
                <tr>
                    <td>* <fmt:message key="campo.dosagem"/>:</td>

                    <td><input type="text" value="<fmt:formatNumber value="${vacina.dosagem}" pattern="0.00"/>" name="dosagem" size="10"/></td>
                </tr>

                <%--<tr>
                    <td><fmt:message key="campo.marca"/>:</td>
                    <td>
                        <select name="marca">
                            <c:forEach var="marca" items="${marcas}">
                                    <option value="${marca.id}" ${vacina.marca.id==marca.id?'selected':''}>${marca.nome}</option>
                            </c:forEach>
                        </select>
                    </td>                
                </tr> --%>

            </table>
            <input type="submit" value="<fmt:message key="botao.enviar"/>"/>
            <a href="<c:url value="/VacinasController"/>"><fmt:message key="botao.voltar"/></a>

            <c:if test="${!empty erro}">
                <div style="color: red;">
                    ${erro}
                </div>
            </c:if>
        </form>
        <img src="imagens/ze_gotinha-2.jpg" align="right">
    </body>
</html>
=======

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Vacina"%>
<%@page contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <h1> <fmt:message key="titulo.editarvacina"/></h1>
        <form action="<c:url value="/VacinasController"/>" method="post">
            <table>
                <c:if test="${!empty vacina.id}">    
                    <tr>
                        <td><fmt:message key="campo.id"/>:</td>
                        <td><input type="text" value="${vacina.id}" name="id" size="10" readonly    /></td>
                    </tr>
                </c:if>
                <tr>
                    <td>* <fmt:message key="campo.nome"/>:</td>
                    <td><input type="text" value="${vacina.nome_vacina}" name="nome_vacina" size="100"/></td>
                </tr>

                <tr>
                    <td><fmt:message key="campo.descricao"/>:</td>
                    <td><textarea name="info_vacina" cols="80" rows="5">${vacina.info_vacina}</textarea></td>
                </tr>
                <tr>
                    <td>* <fmt:message key="campo.dosagem"/>:</td>

                    <td><input type="text" value="<fmt:formatNumber value="${vacina.dosagem}" pattern="0.00"/>" name="dosagem" size="10"/></td>
                </tr>

                <%--<tr>
                    <td><fmt:message key="campo.marca"/>:</td>
                    <td>
                        <select name="marca">
                            <c:forEach var="marca" items="${marcas}">
                                    <option value="${marca.id}" ${vacina.marca.id==marca.id?'selected':''}>${marca.nome}</option>
                            </c:forEach>
                        </select>
                    </td>                
                </tr> --%>

            </table>
            <input type="submit" value="<fmt:message key="botao.enviar"/>"/>
            <a href="<c:url value="/VacinasController"/>"><fmt:message key="botao.voltar"/></a>

            <c:if test="${!empty erro}">
                <div style="color: red;">
                    ${erro}
                </div>
            </c:if>
        </form>
        <img src="imagens/ze_gotinha-2.jpg" align="right">
    </body>
</html>
>>>>>>> origin/master
