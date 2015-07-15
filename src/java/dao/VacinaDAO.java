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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vacina;
import util.ConectaBanco;

/**
 *
 * @author Edu
 */
public class VacinaDAO {
//private static final String INSERT = ("insert into vacina (nome_vacina, dosagem, info_vacina) values (?, ?, ?)");
    public Vacina buscarPorId(int id) {
        Connection conexao = null;
        Vacina vacina = new Vacina();
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("select * from vacina where id = ? ");
         //   PreparedStatement pstmt = conexao.prepareStatement("select v.*, m.id id_marca, m.nome nome_marca "
                //    + "from vacinas v, marcas m where v.id = ? and v.marcas_id = m.id");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vacina.setId(rs.getInt("id"));
                vacina.setNome_vacina(rs.getString("nome_vacina"));
                vacina.setDosagem(rs.getInt("dosagem"));
                vacina.setInfo_vacina(rs.getString("info_vacina"));
           }
            return vacina;
        } catch (SQLException sql) {
            Logger.getLogger(VacinaDAO.class.getName()).log(Level.SEVERE, null, sql);
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
        return null;
    }

    public List<Vacina> buscarTudo() {
        Connection conexao = null;
        List<Vacina> vacinas = new ArrayList<Vacina>();
        try {
            conexao = new ConectaBanco().getConnection();
              PreparedStatement pstmt = conexao.prepareStatement("select* from vacina order by nome_vacina");
         //   PreparedStatement pstmt = conexao.prepareStatement("select v.*, m.id id_marca, m.nome nome_marca from vacinas v, marcas m where v.marcas_id = m.id order by v.nome");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Vacina vacina = new Vacina();
                vacina.setId(rs.getInt("id"));
                vacina.setNome_vacina(rs.getString("nome_vacina"));
                vacina.setDosagem(rs.getInt("dosagem"));
                vacina.setInfo_vacina(rs.getString("info_vacina"));
                vacinas.add(vacina);
            }
            return vacinas;
        } catch (SQLException sql) {
            Logger.getLogger(VacinaDAO.class.getName()).log(Level.SEVERE, null, sql);
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
        return null;
    }
/*public boolean inserir (Vacina vacina){
    Connection conexao = null;
    try{
         conexao = new ConectaBanco().getConnection();
        PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, vacina.getNome_vacina());
            pstmt.setInt(2, vacina.getDosagem());
            pstmt.setString(3, vacina.getInfo_vacina());
            pstmt.execute();
    }catch (Exception e){
        throw new RuntimeException(e);
    }finally{
    try{
        conexao.close();
    }catch(SQLException e){
        throw  new RuntimeException(e);
    }
}
    return false;
}*/
    public boolean inserir(Vacina vacina) {
        Connection conexao = null;
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("insert into vacina (nome_vacina, dosagem, info_vacina) values (?, ?, ?)");
            pstmt.setString(1, vacina.getNome_vacina());
            pstmt.setInt(2, vacina.getDosagem());
            pstmt.setString(3, vacina.getInfo_vacina());
            pstmt.execute();
           return true;
        } catch (SQLException sql) {
            Logger.getLogger(VacinaDAO.class.getName()).log(Level.SEVERE, null, sql);
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
                                                                                   
    public boolean atualizar(Vacina vacina) {
        Connection conexao = null;
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("update vacina set nome_vacina = ?, dosagem = ?, info_vacina = ? where id = ?");
//  PreparedStatement pstmt = conexao.prepareStatement("update vacinas set nome = ?, descricao = ?, dose = ?, marcas_id = ? where id = ?");
            pstmt.setString(1, vacina.getNome_vacina());
            pstmt.setInt(2, vacina.getDosagem());
            pstmt.setString(3, vacina.getInfo_vacina());
            pstmt.setInt(4, vacina.getId());
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

    public boolean deletar(Vacina vacina) {
        Connection conexao = null;
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("delete from vacina where id = ?");
            pstmt.setInt(1, vacina.getId());
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
    

