package Controler;

import DAO.EmpresaDao;
import DAO.PessoaDao;
import DAO.ProdutoDao;
import DAO.ServicoDao;
import Model.Empresa;
import Model.Pessoa;
import Model.Produto;
import Model.Servico;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sigepes.CadastrarEmpresa;
import sigepes.CadastrarPessoa;
import sigepes.CadastrarProduto;
import sigepes.CadastrarServico;
import sigepes.ListarEmpresa;
import sigepes.ListarPessoa;
import sigepes.ListarProduto;
import sigepes.ListarServico;
import sigepes.Login;
import sigepes.Principal;


public class PrincipalController implements Initializable {

    @FXML
    private Button btTrocarUsuario;

    @FXML
    private Button btCadastrarProduto;

    @FXML
    private Button btPesquisar;

    @FXML
    private Button btListarProduto;

    @FXML
    private Button btCadastrarServico;

    @FXML
    private Button btCadastrarEmpresa;

    @FXML
    private Button btListarPessoa;

    @FXML
    private Button btListarServico;

    @FXML
    private Button btSair;

    @FXML
    private Button btCadastrarPessoa;

    @FXML
    private Button btListarEmpresa;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    btCadastrarEmpresa.setOnMouseClicked((MouseEvent e)->{
            CadastrarEmpresa emp = new CadastrarEmpresa();
            AbreCadEmpresa();
    });
        
    btCadastrarEmpresa.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
             AbreCadEmpresa();
          }
    });  
    
    btCadastrarPessoa.setOnMouseClicked((MouseEvent e)->{
            CadastrarPessoa pessoa = new CadastrarPessoa();
            AbreCadPessoa();
    });
        
    btCadastrarPessoa.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              AbreCadPessoa();
          }
    });  
    
     btCadastrarServico.setOnMouseClicked((MouseEvent e)->{
            CadastrarPessoa pessoa = new CadastrarPessoa();
            AbreCadServico();
    });
        
    btCadastrarServico.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              AbreCadServico();
          }
    });  
    
     btCadastrarProduto.setOnMouseClicked((MouseEvent e)->{
            CadastrarPessoa pessoa = new CadastrarPessoa();
            AbreCadProduto();
    });
        
    btCadastrarProduto.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              AbreCadProduto();
          }
    });  
    
     btSair.setOnMouseClicked((MouseEvent e)->{
            fecha();
    });
     
     btSair.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              fecha();
          }
          });  
     
      btTrocarUsuario.setOnMouseClicked((MouseEvent e)->{
            AbreLogin();   
    });
        
    btTrocarUsuario.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            AbreLogin();
          }
    });  
    
    btListarProduto.setOnMouseClicked((MouseEvent e)->{
            listaProduto();
    });
        
    btListarProduto.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            listaProduto();
          }
    });  
    
    btListarEmpresa.setOnMouseClicked((MouseEvent e)->{
            listaEmpresa();
    });
        
    btListarEmpresa.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            listaEmpresa();
          }
    }); 
    
    btListarPessoa.setOnMouseClicked((MouseEvent e)->{
            listaPessoa();
    });
        
    btListarPessoa.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            listaPessoa();
          }
    }); 
    
    btListarServico.setOnMouseClicked((MouseEvent e)->{
            listaServico();
    });
        
    btListarServico.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            listaServico();
          }
    }); 
    
    
    
    
    }    
    
    public void AbreCadEmpresa(){
         CadastrarEmpresa emp = new CadastrarEmpresa();
              fecha();
        try {
            emp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void AbreCadPessoa(){
              CadastrarPessoa pessoa = new CadastrarPessoa();
              fecha();
        try {
            pessoa.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AbreCadServico(){
              CadastrarServico servico = new CadastrarServico();
              fecha();
        try {
            servico.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AbreCadProduto(){
              CadastrarProduto produto = new CadastrarProduto();
              fecha();
        try {
            produto.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void fecha(){
        Principal.getStage().close();
    }
    
    public void AbreLogin(){
            Login login = new Login();
              fecha();
        try {
            login.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void listaEmpresa(){
        
        ListarEmpresa a = new ListarEmpresa();
              fecha();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("LISTANDO EMPRESAS");
        List<Empresa> empresas = new EmpresaDao().getList();
        for(int x = 0; x < empresas.size(); x++){
            empresas.get(x).mostraEmpresa();
        }
    }
    
    public void listaProduto(){
        ListarProduto b = new ListarProduto();
              fecha();
        try {
            b.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("LISTANDO PRODUTOS");
        List<Produto> produtos = new ProdutoDao().getList();
        for(int x = 0; x < produtos.size(); x++){
            produtos.get(x).mostraProduto();
        }
    }
    
    public void listaPessoa(){
        ListarPessoa c = new ListarPessoa();
              fecha();
        try {
            c.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("LISTANDO PESSOAS");
        List<Pessoa> pessoas = new PessoaDao().getList();
        for(int x = 0; x < pessoas.size(); x++){
            pessoas.get(x).mostraPessoa();
        }
    }
    
    public void listaServico(){
        ListarServico d = new ListarServico();
              fecha();
        try {
            d.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("LISTANDO SERVIÇOS");
        List<Servico> servicos = new ServicoDao().getList();
        for(int x = 0; x < servicos.size(); x++){
            servicos.get(x).mostraServico();
        }
    }
    
}
