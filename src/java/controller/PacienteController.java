/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;

/**
 *
 * @author Caio
 */
public class PacienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PacienteDAO dao = new PacienteDAO();
        if (request.getParameter("idDelete") != null) {
            Paciente paciente = new Paciente();
            paciente.setSuv(Integer.parseInt(request.getParameter("idDelete")));
            dao.excluir(paciente);
            response.sendRedirect("PacienteController");
        } else {
            if (request.getParameter("idEditar") != null) {
                Paciente paciente = dao.consultar(Integer.parseInt(request.getParameter("idEditar")));
                request.setAttribute("paciente", paciente);
                request.getRequestDispatcher("admin/editarPaciente.jsp").forward(request, response);
            } else {
                List<Paciente> pacientes = dao.listarTudo();
                request.setAttribute("pacientes", pacientes);
                request.getRequestDispatcher("admin/indexPaciente.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paciente paciente = new Paciente();
        PacienteDAO dao = new PacienteDAO();
        paciente.setNome(request.getParameter("nome"));
        paciente.setCpf(Integer.parseInt(request.getParameter("cpf")));
        paciente.setDt_nascimento(Date.valueOf(request.getParameter("dt_nascimento")));
        paciente.setEndereco(request.getParameter("endereco"));
        paciente.setTelefone(request.getParameter("telefone"));
        paciente.setEmail(request.getParameter("email"));
        paciente.setSexo(request.getParameter("sexo"));
        paciente.setNivel_acesso(Integer.parseInt(request.getParameter("nivelAcesso")));
        paciente.setLogin(request.getParameter("login"));
        paciente.setSenha(request.getParameter("senha"));

        NumberFormat nf = NumberFormat.getNumberInstance();
        try {
            paciente.setSuv(Integer.parseInt(request.getParameter("suv")));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        
        

        if (!request.getParameter("suv").equals("0") && !request.getParameter("suv").equals("")) {
            dao.atualizar(paciente);
            response.sendRedirect("PacienteController");
        } else {
            if (dao.cadastrar(paciente)) {
                response.sendRedirect("PacienteController");
            } else {
                request.setAttribute("erro", "Ocorreu um erro!!");
                request.setAttribute("paciente", paciente);
                request.getRequestDispatcher("admin/editarPaciente.jsp").forward(request, response);
            }

        }
    }

}