
package controller;
import java.sql.Date;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PerfilDeAcesso;
import model.ProfissionalDeSaude;
import dao.ProfissionalDeSaudeDAO;
import java.text.SimpleDateFormat;

public class ControleUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("Cadastrar")) {
                ProfissionalDeSaude usuario = new ProfissionalDeSaude();
  //      SimpleDateFormat formatador = new SimpleDateFormat("dd/mm/yyyy");
        
                usuario.setNome(request.getParameter("Nome"));
    //            usuario.setDt_nascimento((Date) formatador.parse("dt_nascimento"));
                usuario.setDt_nascimento(Date.valueOf(request.getParameter("dt_nascimento")));      
                usuario.setLogin (request.getParameter("Login"));
                usuario.setSenha (request.getParameter("senha"));
                
                String id_nivel = request.getParameter("id_nivel");
                if (id_nivel.equalsIgnoreCase("administrador")) {
                    usuario.setPerfil(PerfilDeAcesso.ADMINISTRADOR);
                } else {
                    usuario.setPerfil(PerfilDeAcesso.COMUM);
                }

                ProfissionalDeSaudeDAO usuarioDAO = new ProfissionalDeSaudeDAO();
                usuarioDAO.cadastraNovoUsuario(usuario);
                request.setAttribute("msg", "cadastrado com sucesso");
                RequestDispatcher rd = request.getRequestDispatcher("/admin/cadastro_usuario.jsp");
                rd.forward(request, response);
            }
        } catch (Exception erro) {
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
