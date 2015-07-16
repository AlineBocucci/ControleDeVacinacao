<%-- 
    Document   : editarPaciente
    Created on : 04/06/2015, 20:07:26
    Author     : Caio
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <h1><fmt:message key="titulo.editarPaciente"/></h1>
        <form>
            <table>
                <c:if test="${!empty paciente.suv}">
                    <tr>
                        <td><fmt:message key="campo.suv"/>:</td>
                        <td><input type="text" value="${paciente.suv}" name="id" size="10" readonly    /></td>
                    </tr>
                </c:if>
                <tr>
                    <td>* <fmt:message key="campo.nome"/>:</td>
                    <td><input type="text" value="${paciente.nome}" name="nome" size="100"/></td>
                </tr>
                <tr>
                    <td>* <fmt:message key="campo.cpf"/>:</td>
                    <td><input type="text" value="${paciente.cpf}" name="cpf" size="100"/></td>
                </tr>
                <tr>
                    <td>* <fmt:message key="campo.dataNascimento"/>:</td>
                    <td><input type="date" value="${paciente.dt_nascimento}" name="dataNascimento" size="100" min="1850-01-01" /></td>
                </tr>
                <tr>
                    <td>* <fmt:message key="campo.endereco"/>:</td>
                    <td><input type="text" value="${paciente.endereco}" name="endereco" size="100"/></td>
                </tr>
                <tr>
                    <td>* <fmt:message key="campo.telefone"/>:</td>
                    <td><input type="text" value="${paciente.telefone}" name="telefone" size="100"/></td>
                </tr>
                <tr>
                    <td>* <fmt:message key="campo.email"/>:</td>
                    <td><input type="email" value="${paciente.email}" name="email" size="100" required /></td>
                </tr>
                <tr>
                    <td>* <fmt:message key="campo.sexo"/>:</td>
                    <td><input type="text" value="${paciente.sexo}" name="sexo" size="100"/></td>
                </tr>



            </table>
            <input type="submit" value="<fmt:message key="botao.enviar"/>"/>
            <a href="<c:url value="/PacienteController"/>"><fmt:message key="botao.voltar"/></a>
            <c:if test="${!empty erro}">
                <div style="color: red;">
                    ${erro}
                </div>
            </c:if>
        </form>
        <img src="imagens/ze_gotinha-2.jpg" align="right">
    </body>
</html>
