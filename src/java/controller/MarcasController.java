/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MarcaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marca;

/**
 *
 * @author Misael
 */
public class MarcasController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MarcaDAO dao = new MarcaDAO();
        if (request.getParameter("idDelete") != null) {
            Marca marca = new Marca();
            marca.setId(Integer.parseInt(request.getParameter("idDelete")));
            dao.deletar(marca);
            response.sendRedirect("marcasController");
        } else {
            if (request.getParameter("idEditar") != null) {
                Marca marca = dao.buscarPorId(Integer.parseInt(request.getParameter("idEditar")));
                request.setAttribute("marca", marca);
                request.getRequestDispatcher("admin/marcaEditar.jsp").forward(request, response);
            } else {
                List<Marca> marcas = dao.buscarTudo();
                request.setAttribute("marcas", marcas);
                request.getRequestDispatcher("admin/indexMarca.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Marca marca = new Marca();
        MarcaDAO dao = new MarcaDAO();
        marca.setNome(request.getParameter("nome"));
        try {
            marca.setId(Integer.parseInt(request.getParameter("id")));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        if (marca.getNome().equals("") || marca.getNome() == null) {
            request.setAttribute("erro", "Campo obrigatório não preenchido!");
            request.setAttribute("marca", marca);
            request.getRequestDispatcher("admin/marcaEditar.jsp").forward(request, response);
            return;
        }
        if (!request.getParameter("id").equals("0") && !request.getParameter("id").equals("")) {
            dao.atualizar(marca);
            response.sendRedirect("marcasController");
        } else {
            if (dao.inserir(marca)) {
                response.sendRedirect("marcasController");
            } else {
                request.setAttribute("erro", "Ocorreu um erro!!");
                request.setAttribute("vacina", marca);
                request.getRequestDispatcher("admin/marcaEditar.jsp").forward(request, response);
            }

        }
    }
}
