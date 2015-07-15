<%-- 
    Document   : indexPaciente
    Created on : 04/06/2015, 20:58:43
    Author     : Caio
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pacientes</title>
    </head>
    <body>
        <h1><fmt:message key="titulo.editarPaciente"/></h1>
        
        <table border="1">
            <thead>
            <th><fmt:message key="campo.suv"/></th>    
            <th><fmt:message key="campo.nome"/></th>
            <th><fmt:message key="campo.cpf"/></th>
            <th><fmt:message key="campo.dataNascimento"/></th>
            <th><fmt:message key="campo.endereco"/></th>
            <th><fmt:message key="campo.telefone"/></th>
            <th><fmt:message key="campo.email"/></th>
            <th><fmt:message key="campo.sexo"/></th>
            </thead>    
            <c:forEach var="paciente" items="${pacientes}">
            
            <tr>
                <td>${paciente.suv}</td>
                <td>${paciente.nome}</td>
                <td>${paciente.cpf}</td>                
                <td>${paciente.dt_nascimento}</td>
                <td>${paciente.endereco}</td>
                <td>${paciente.telefone}</td>
                <td>${paciente.email}</td>
                <td>${paciente.sexo}</td>
                <td><a href="PacienteController?idEditar=${paciente.suv}"><fmt:message key="botao.editar"/></a></td>
                <td><a href="PacienteController?idDelete=${paciente.suv}"><fmt:message key="botao.apagar"/></a></td>
            </tr>           
            </c:forEach>
            
        </table>
            <a href="<c:url value="/"/>/PacienteController?idEditar=0"><fmt:message key="botao.novo"/></a>
            <a href="admin/menu.jsp"><fmt:message key="campo.voltar"/></a>
            <img src="imagens/ze_gotinha-2.jpg" align="right">
    </body>
</html>
