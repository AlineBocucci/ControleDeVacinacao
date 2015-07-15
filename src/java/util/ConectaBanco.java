package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
    
 /*   public static Connection getConnection() throws ClassNotFoundException {
        Connection conexao = null;
        try{
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SUV"
             ,"postgres", "1234");
    }catch( RuntimeException erro1){
        throw new RuntimeException(erro1);
    }catch (SQLException erro2){
        throw new RuntimeException (erro2);
    }
    return conexao;
}
}*/
    public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver"); 
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/SUV"
                    ,"postgres", "1234"); 
       } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
