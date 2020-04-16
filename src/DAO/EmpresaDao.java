package DAO;

import JDBC.ConnectionFactory;
import Model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmpresaDao {
    private final Connection con;
    
    public EmpresaDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean add(Empresa p){
        String sql = "INSERT INTO Empresa(nome,cnpj,nicho,descri) VALUES (?,?,?,?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCnpj());
            stmt.setString(3, p.getNicho());
            stmt.setString(4, p.getDescri());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean update(Empresa p){
        String sql = "UPDATE empresa SET nome = ?, cnpj = ?, nicho = ?, descri = ?, WHERE id=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCnpj());
            stmt.setString(3, p.getNicho());
            stmt.setString(4, p.getDescri());
            stmt.setLong(5, p.getID());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(Empresa p){
        String sql = "DELETE FROM empresa WHERE id=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, p.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Empresa> getList(){
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM empresa";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Empresa p = new Empresa();
                p.setId(rs.getLong("id")); //Essa string por parametro é o nome da coluna la no banco
                p.setNome(rs.getString("nome"));
                p.setCnpj(rs.getString("cnpj"));
                p.setNicho(rs.getString("nicho"));
                p.setDescri(rs.getString("descri"));
                empresas.add(p);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {     
            System.out.println("Erro, lista não foi retornada!");
            return null;
        }
        return empresas;
    }
}
