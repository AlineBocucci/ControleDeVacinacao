    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="titulo.cadastrousuario"/></title>
    </head>
    <body>
        <h1><fmt:message key="titulo.arearestrita"/></h1>
            <h2><fmt:message key="titulo.cadastronovo"/></h2>

        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
        %>
        <font color="blue"><%=msg%></font>
        <%}%>
        <form action="../ControleUsuario" method="POST">
            
            <fmt:message key="campo.id"/><input type="text" name="txtId"><br/>
            <fmt:message key="campo.nome"/><input type="text" name="txtNome"><br/>
            <fmt:message key="campo.dt_nascimento"/><input type="Date" name="Dt_nascimento"><br/> 
            <fmt:message key="campo.n_coren"/><input type="text" name="txtn_coren"><br/>
            <fmt:message key="campo.dt_emissao_coren"/><input type="Date" name="dt_emissao_coren"><br/>            
            <fmt:message key="campo.dt_vencimento_coren"/><input type="Date" name="dt_vencimento_coren"><br/> 
            <fmt:message key="campo.status"/><input type="text" name="txtStatus"><br/>          
        <%--<fmt:message key="campo.nivel_acesso"/><input type="text" name="txtNivelAcesso"><br/> --%>
            <fmt:message key="campo.senha"/><input type="password" name="txtSenha"><br/>
            <fmt:message key="campo.login"/><select name="optNivel_acesso">
                <option><fmt:message key="perfil.comum"/></option>
                <option><fmt:message key="perfil.admin"/></option>
            </select><br/>
            <input type="submit" value="<fmt:message key="botao.cadastrar"/>" name="acao">
 <img src="imagens/ze_gotinha-2.jpg" align="right">
        </form>	
        <a href="./menu.jsp"><fmt:message key="link.menu"/></a>
       

    </body>
</html>
