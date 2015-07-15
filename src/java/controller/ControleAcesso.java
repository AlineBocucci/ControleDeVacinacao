package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProfissionalDeSaude;
import dao.ProfissionalDeSaudeDAO;

public class ControleAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String acao = request.getParameter("acao");
            if (acao.equals("Entrar")) {
                ProfissionalDeSaude usuario = new ProfissionalDeSaude();
                usuario.setLogin(request.getParameter("txtLogin"));
                usuario.setSenha(request.getParameter("txtSenha"));
                ProfissionalDeSaudeDAO usuarioDAO = new ProfissionalDeSaudeDAO();
                ProfissionalDeSaude usuarioAutenticado = usuarioDAO.autenticaUsuario(usuario);
                //se o usuario existe no banco de dados
                if (usuarioAutenticado != null) {
                    //cria uma sessao para o usuario
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
                    
                    String naFigura = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
                    String digitado = request.getParameter("kaptcha");

                    if (digitado.equals(naFigura)) {
                        //Vai até o banco de dados para fazer a consulta do usuário.
                        response.setContentType("text/plain");
                        PrintWriter out = response.getWriter();
                        out.println("Usuário válido!");
                    } else {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    //redireciona para a pagina princiapal
                    response.sendRedirect("principal.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            } else if (acao.equals("Sair")) {
                HttpSession sessaoUsuario = request.getSession();
                sessaoUsuario.removeAttribute("usuarioAutenticado");
                response.sendRedirect("logout.jsp");

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
