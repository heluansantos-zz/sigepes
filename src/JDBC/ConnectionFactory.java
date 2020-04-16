package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
    public Connection getConnection(){
        try {
            String nomeUsuario = "postgres";
            String senhaUsuario = "Hesoyam";
            String enderecoServidor = "localhost";
            String nomeBanco = "SIGEPESdb";
            
            return DriverManager.getConnection("jdbc:postgresql://"+enderecoServidor+
                    "/"+nomeBanco,nomeUsuario,senhaUsuario);
        } catch (SQLException ex) {
            System.out.println("Erro, não abre conexão com banco de dados");
           throw new RuntimeException(ex);
        }
    }
}
 