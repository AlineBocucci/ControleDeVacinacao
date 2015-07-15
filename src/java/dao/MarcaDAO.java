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
import model.Marca;
import util.ConectaBanco;

/**
 *
 * @author Misael
 */
public class MarcaDAO {
 public Marca buscarPorId(int id) {  
Connection conexao = null;
        Marca marca = new Marca();
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("select * from marcas where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
               
            }
            return marca;
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

    public List<Marca> buscarTudo() {
        Connection conexao = null;
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("select * from marcas order by nome");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
                marcas.add(marca);
            }
            return marcas;
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

    public boolean inserir(Marca marca) {
        Connection conexao = null;
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("insert into vmarcas (nome)values(?)");
            pstmt.setString(1, marca.getNome());
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

    public boolean atualizar(Marca marca) {
        Connection conexao = null;
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("update marcas set nome = ?  where id = ?");
            pstmt.setString(1, marca.getNome());
            pstmt.setInt(2, marca.getId());
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

    public boolean deletar(Marca marca) {
        Connection conexao = null;
        try {
            conexao = new ConectaBanco().getConnection();
            PreparedStatement pstmt = conexao.prepareStatement("delete from marcas where id = ?");
            pstmt.setInt(1, marca.getId());
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
  /*  public List<Marca> buscarTudo() {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement("select * from marcas order by nome");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
                marcas.add(marca);
            }
            return marcas;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    public Marca setNomePorId(int id) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Marca marca = new Marca();
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement("select * from marcas where id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
            }
            return marca;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
        }
        return null;
    }

    public Marca buscarPorId(int id) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Marca marca = new Marca();
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement("select * from marcas where id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
            }
            return marca;
        } catch (SQLException ex1) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex1);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    public boolean inserir(Marca marca) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement("insert into marcas (nome) values (?)");
            pstmt.setString(1, marca.getNome());
            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return false;
    }

    public boolean atualizar(Marca marca) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement("update  marcas set nome=? where id=?");
            pstmt.setString(1, marca.getNome());
            pstmt.setInt(2, marca.getId());
            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return false;
    }

    public boolean deletar(Marca marca) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try{
            conexao=ConectaBanco.getConexao();
            pstmt=conexao.prepareStatement("delete from marcas where id=?");
            pstmt.setInt(1, marca.getId());
            pstmt.execute();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(conexao!=null){
                    conexao.close();
                }
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
        }
        return false;
    }*/
}
