package controller;

import dao.VacinaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vacina;

public class VacinasController extends HttpServlet {
   /* protected void processRequest (HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
     try{
     String acao = request.getParameter("acao");
     if(acao.equals("Inserir")){
     String nome_vacina = request.getParameter("nome_vacina");
     int dosagem = request.getIntHeader("dosagem");
     String info_vacina = request.getParameter("info_vacina");
            
     Vacina vacina = new Vacina();
     vacina.setNome_vacina(nome_vacina);
     vacina.setDosagem(dosagem);
     vacina.setInfo_vacina(info_vacina);
            
     VacinaDAO dao = new VacinaDAO();
     dao.inserir(vacina);
            
     response.sendRedirect("editarVacina.jsp");
     }else if (acao.equals("Listar")){
        
     }
        
     }catch (Exception e){
     request.setAttribute("erro", e);
     RequestDispatcher rd 
     =request.getRequestDispatcher("/erro.jsp");
     rd.forward(request, response);
     }
     }
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VacinaDAO dao = new VacinaDAO();
        if (request.getParameter("idDelete") != null) {
            Vacina vacina = new Vacina();
            vacina.setId(Integer.parseInt(request.getParameter("idDelete")));
            dao.deletar(vacina);
            response.sendRedirect("VacinasController");
        } else {
            if (request.getParameter("idEditar") != null) {
                Vacina vacina = dao.buscarPorId(Integer.parseInt(request.getParameter("idEditar")));
                request.setAttribute("vacina", vacina);
                /*
                 MarcaDAO marcaDAO = new MarcaDAO();
                 request.setAttribute("marcas", marcaDAO.buscarTudo()); */
                request.getRequestDispatcher("admin/editarVacina.jsp").forward(request, response);
            } else {
                List<Vacina> vacinas = dao.buscarTudo();
                request.setAttribute("vacinas", vacinas);
                request.getRequestDispatcher("admin/indexVacina.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vacina vacina = new Vacina();
        VacinaDAO dao = new VacinaDAO();
        vacina.setNome_vacina(request.getParameter("nome_vacina"));
        // vacina.setDosagem(Integer.parseInt(request.getParameter("dosagem")));
        vacina.setInfo_vacina(request.getParameter("info_vacina"));

        //Marca marca = new Marca();
        //   marca.setId(Integer.parseInt(request.getParameter("marca")));
        //   vacina.setMarca(marca);
        NumberFormat nf = NumberFormat.getNumberInstance();
        try {
            vacina.setDosagem(nf.parse(request.getParameter("dosagem")).intValue());
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        try {
            vacina.setId(Integer.parseInt(request.getParameter("id")));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        //  if (vacina.getNome_vacina().equals("") || vacina.getDosagem() == null) {
        if (vacina.getNome_vacina().equals("") || (vacina.getDosagem() == 0)) {
            request.setAttribute("erro", "Campo obrigatório não preenchido!");
            request.setAttribute("vacina", vacina);
            request.getRequestDispatcher("admin/editarVacina.jsp").forward(request, response);
            return;
        } /*if (vacina.getDosagem() == 0) {
         request.setAttribute("erro", "Campo obrigatório não preenchido!");
         request.setAttribute("vacina", vacina);
         request.getRequestDispatcher("admin/editarVacina.jsp").forward(request, response);
         return;
         }*/ else {

            if (!request.getParameter("id").equals("0") && !request.getParameter("id").equals("")) {
                dao.atualizar(vacina);
                response.sendRedirect("VacinasController");
            } else if (dao.inserir(vacina)) {
                response.sendRedirect("VacinasController");
            } else {
                request.setAttribute("erro", "Ocorreu um erro!!");
                request.setAttribute("vacina", vacina);
                request.getRequestDispatcher("admin/editarVacina.jsp").forward(request, response);
            }
        }
    }
}
