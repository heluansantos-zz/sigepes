package DAO;

import JDBC.ConnectionFactory;
import Model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDao {
    private final Connection con;
    
    public PessoaDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean add(Pessoa p){
        String sql = "INSERT INTO pessoa(nome,email,senha) VALUES (?,?,?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getSenha());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean update(Pessoa p){
        String sql = "UPDATE pessoa SET nome = ?, email = ?, senha = ? WHERE id=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getSenha());
            stmt.setLong(4, p.getID());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(Pessoa p){
        String sql = "DELETE FROM pessoa WHERE id=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, p.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Pessoa> getList(){
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Pessoa p = new Pessoa();
                p.setId(rs.getLong("id")); //Essa string por parametro é o nome da coluna la no banco
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setSenha(rs.getString("senha"));
                pessoas.add(p);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {     
            System.out.println("Erro, lista não foi retornada!");
            return null;
        }
        return pessoas;
    }
}

