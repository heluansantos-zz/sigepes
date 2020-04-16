package DAO;

import JDBC.ConnectionFactory;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoDao {

    private final Connection con;
    
public ProdutoDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean add(Produto p){
        String sql = "INSERT INTO Produto(nome,descri,status,nicho,ordem,preco) VALUES (?,?,?,?,?,?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescri());
            stmt.setString(3, p.getStatus());
            stmt.setString(4, p.getNicho());
            stmt.setString(5, p.getOrdem());
            stmt.setString(6, p.getPreco());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean update(Produto p){
        String sql = "UPDATE produto SET nome = ?, descri = ?, status = ?, ordem = ?, preco = ?, WHERE id=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescri());
            stmt.setString(3, p.getStatus());
            stmt.setString(4, p.getNicho());
            stmt.setString(5, p.getOrdem());
            stmt.setString(6, p.getPreco());
            stmt.setLong(7, p.getID());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(Produto p){
        String sql = "DELETE FROM produto WHERE id=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, p.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Produto> getList(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getLong("id")); //Essa string por parametro é o nome da coluna la no banco
                p.setNome(rs.getString("nome"));
                p.setDescri(rs.getString("descri"));
                p.setStatus(rs.getString("status"));
                p.setNicho(rs.getString("nicho"));
                p.setOrdem(rs.getString("ordem"));
                p.setPreco(rs.getString("preco"));
                produtos.add(p);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {     
            System.out.println("Erro, lista não foi retornada!");
            return null;
        }
        return produtos;
    }
}
