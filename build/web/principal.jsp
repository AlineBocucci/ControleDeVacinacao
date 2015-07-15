<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.ProfissionalDeSaude"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body>
         <div style="float:right;">
         <a href="<c:url value="/Idioma?idioma=pt&pais=br"/>"><fmt:message key="campo.portugues"/></a>
         <a href="<c:url value="/Idioma?idioma=en&pais=us"/>"><fmt:message key="campo.ingles"/></a>
       </div>
         <h1><fmt:message key="campo.tituloautenticacao"/></h1>
        

        <%

            ProfissionalDeSaude usuario = (ProfissionalDeSaude) session.getAttribute("usuarioAutenticado");
            if (usuario != null) {
        %>

        <h1><fmt:message key="campo.boasvindas"/> <%=usuario.getLogin()%> !</h1>
        <%}%>
        <a href="admin/menu.jsp"><fmt:message key="perfil.admin"/></a><br/>
        <a href="ControleAcesso?acao=Sair"><fmt:message key="campo.sair"/></a>
        <img src="imagens/ze_gotinha-2.jpg" align="right">
       
    </body>
</html>
