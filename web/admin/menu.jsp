<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>opção</title>
    </head>
    <body>
        <h1><fmt:message key="link.menu"></fmt:message></h1>
        
       
        <a href="cadastro_usuario.jsp"><fmt:message key="titulo.cadastrousuario"></fmt:message></a>
        <a href="/ControleDeVacinacao/VacinasController"><fmt:message key="campo.listar"></fmt:message></a>
        <a href="/ControleDeVacinacao/marcasController"><fmt:message key="campo.listamarca"></fmt:message></a>
        <a href="/ControleDeVacinacao/principal.jsp"><fmt:message key="link.paginaprincipal"></fmt:message></a>
        
      <img src="imagens/ze_gotinha-2.jpg" align="right">
    </body>
</html>
