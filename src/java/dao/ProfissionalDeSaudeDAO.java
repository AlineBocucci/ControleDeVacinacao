package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.NivelDeAcesso;
import model.PerfilDeAcesso;
import model.ProfissionalDeSaude;
import util.ConectaBanco;

public class ProfissionalDeSaudeDAO {

    private static final String CADASTRA_NOVO_USUARIO = "INSERT INTO ProfissionalDeSaude (nome, dt_nascimento, n_coren, dt_emissao_coren, dt_vencimento_coren, status, nivel_acesso, login, senha) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String AUTENTICA_USUARIO = "SELECT * FROM ProfissionalDeSaude WHERE login=? AND senha=?";

    public void cadastraNovoUsuario(ProfissionalDeSaude usuario) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = new ConectaBanco().getConnection();
            pstmt = conexao.prepareStatement(CADASTRA_NOVO_USUARIO);
            pstmt.setString(1,usuario.getNome());
            pstmt.setDate(2,usuario.getDt_nascimento());
            pstmt.setInt(3,usuario.getN_coren());
            pstmt.setDate(4,usuario.getDt_emissao_coren());
            pstmt.setDate(5,usuario.getDt_vencimento_coren());
            pstmt.setString(6,usuario.getStatus());
            pstmt.setString(7,usuario.getNivel_acesso());
            pstmt.setString(8, usuario.getLogin());
            pstmt.setString(9, usuario.getSenha());
            
            //NivelDeAcesso nivel = new NivelDeAcesso(); 
            //pstmt.setInt(6, nivel.getId());
            pstmt.execute();
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public ProfissionalDeSaude autenticaUsuario(ProfissionalDeSaude usuario) throws ClassNotFoundException {
        ProfissionalDeSaude usuarioAutenticado = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsUsuario = null;
        try {
            conexao = new ConectaBanco().getConnection();
            pstmt = conexao.prepareStatement(AUTENTICA_USUARIO);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            rsUsuario = pstmt.executeQuery();
            if (rsUsuario.next()) {
                usuarioAutenticado = new ProfissionalDeSaude();
                usuarioAutenticado.setLogin(rsUsuario.getString("login"));
                usuarioAutenticado.setSenha(rsUsuario.getString("senha"));
                usuarioAutenticado.setPerfil(PerfilDeAcesso.valueOf(rsUsuario.getString("nivel_acesso")));
            }
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return usuarioAutenticado;
    }
}
