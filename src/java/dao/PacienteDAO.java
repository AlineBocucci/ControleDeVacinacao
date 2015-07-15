/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import model.Paciente;
import util.ConectaBanco;
import java.util.logging.Level;

/**
 *
 * @author Caio
 */
public class PacienteDAO {

    public Paciente consultar(int suv) {
        Connection conexao = null;
        Paciente paciente = new Paciente();

        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("Select p.* " + "from paciente p where p.suv = ?");
            pstmt.setInt(1, suv);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                paciente.setSuv(rs.getInt("suv"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getInt("cpf"));
                paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setNivel_acesso(rs.getInt("nivel_acesso"));
                paciente.setLogin(rs.getString("login"));
                paciente.setSenha(rs.getString("senha"));
            }
            return paciente;
        } catch (SQLException sql) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }
        }
        return null;
    }

    public List<Paciente> listarTudo(){
        Connection conexao = null;
        List<Paciente> pacientes = new ArrayList<Paciente>();
        try{
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("Select p.* from paciente p order by p.nome");
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()){
                Paciente paciente = new Paciente();
                paciente.setSuv(rs.getInt("suv"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getInt("cpf"));
                paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setNivel_acesso(rs.getInt("nivel_acesso"));
                paciente.setLogin(rs.getString("login"));
                paciente.setSenha(rs.getString("senha"));
                pacientes.add(paciente);
            }
            return pacientes;
        }catch(SQLException sql){
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null,sql);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            try{
                if(conexao != null){
                    conexao.close();
                }
            }catch(SQLException ex2){
                throw new  RuntimeException(ex2);
            }
        }
        return null;
    }
    
    public boolean cadastrar(Paciente paciente){
        Connection conexao = null;
        try{
            conexao = new  ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("insert  into Paciente (nome, cpf, dt_nascimento, endereco,  telefone, email, sexo,  nivel_acesso, login, senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            //pstmt.setInt(1, paciente.getSuv());
            pstmt.setString(1, paciente.getNome());
            pstmt.setInt(1, paciente.getCpf());
            pstmt.setDate(1, paciente.getDt_nascimento());
            pstmt.setString(1, paciente.getEndereco());
            pstmt.setString(1, paciente.getTelefone());
            pstmt.setString(1, paciente.getEmail());
            pstmt.setString(1, paciente.getSexo());
            pstmt.setInt(1, paciente.getNivel_acesso());
            pstmt.setString(1, paciente.getLogin());
            pstmt.setString(1, paciente.getSenha());
            pstmt.execute();
            return true;
        }catch (SQLException sql){
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, sql);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             try {
                if (conexao != null) {
                    conexao.close();
                }
            }catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }
        }
        return false;
    }
    
    public boolean atualizar(Paciente paciente){
        Connection conexao = null;
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("update paciente set endereco = ?, telefone = ?, email = ?, senha = ? where id = ?");
            pstmt.setString(1, paciente.getEndereco());
            pstmt.setString(2, paciente.getTelefone());
            pstmt.setString(3, paciente.getEmail());
            pstmt.setString(4, paciente.getSenha());
            pstmt.setInt(5, paciente.getSuv());
            pstmt.execute();
            return true;
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VacinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }
        }
        return false;
    }
    
     public boolean excluir(Paciente paciente){
        Connection conexao = null;
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("delete from paciente where id = ?");
            pstmt.setInt(1, paciente.getSuv());
            pstmt.execute();
            return true;
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VacinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }
        }
        return false;
    }
}