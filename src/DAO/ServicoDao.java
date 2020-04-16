package DAO;

import JDBC.ConnectionFactory;
import Model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicoDao {
    
private final Connection con;
    
public ServicoDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean add(Servico p){
        String sql = "INSERT INTO servico(titulo,descri,ordem,status) VALUES (?,?,?,?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getTitulo());
            stmt.setString(2, p.getDescri());
            stmt.setString(3, p.getOrdem());
            stmt.setString(4, p.getStatus());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean update(Servico p){
        String sql = "UPDATE servico SET titulo = ?, descri = ?, ordem = ?, status = ?, WHERE id=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getTitulo());
            stmt.setString(2, p.getDescri());
            stmt.setString(3, p.getOrdem());
            stmt.setString(4, p.getStatus());
            stmt.setLong(7, p.getID());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(Servico p){
        String sql = "DELETE FROM servico WHERE id=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, p.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Servico> getList(){
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM servico";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Servico p = new Servico();
                p.setId(rs.getLong("id")); //Essa string por parametro é o nome da coluna la no banco
                p.setTitulo(rs.getString("titulo"));
                p.setDescri(rs.getString("descri"));
                p.setOrdem(rs.getString("ordem"));
                p.setStatus(rs.getString("Status"));
                servicos.add(p);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {     
            System.out.println("Erro, lista não foi retornada!");
            return null;
        }
        return servicos;
    }
}

