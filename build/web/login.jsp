<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="FolhadeEstilo.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="campo.tituloautenticacao"/></title>
    </head>
    <body>

        <div align="center">
            <h1 align="center"><fmt:message key="campo.titulo"/></h1>
            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
            %>
            <font color="red"><%=msg%></font>
            <%}%>
            <form action="ControleAcesso" method="POST">
                <fmt:message key="campo.login"/><input type="text" name="txtLogin"/><br><br>
                <fmt:message key="campo.senha"/><input type="password" name="txtSenha"/><br><br>
                <img src="kaptcha.jpg" align="center"/> <br><br>
                <fmt:message key="campo.kaptcha" /> <br><br>
                <input type="text" name="kaptcha" value="" > <br><br>
                <input type="submit" value="<fmt:message key="botao.entrar"/>" name="acao">
            </form>	
            <img src="imagens/ze_gotinha-2.jpg" align="right">
        </div>


    </body>
</html>