package Controler;

import DAO.ProdutoDao;
import Model.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sigepes.CadastrarPessoa;
import sigepes.CadastrarProduto;
import sigepes.Principal;


public class CadastrarProdutoController implements Initializable {

    @FXML
    private TextField txStatus;

    @FXML
    private TextField txOrdem;

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField txPreco;

    @FXML
    private TextField txDescri;

    @FXML
    private TextField txNome;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField txNicho;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   btCancelar.setOnMouseClicked((MouseEvent e)->{
            abrePrincipal();
    });
        
    btCancelar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            abrePrincipal();
          }
    });  
    
    btCadastrar.setOnMouseClicked((MouseEvent e)->{
            cadastraProduto();
            
    });
        
    btCadastrar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              cadastraProduto();
              
          }
    });  
    }    
    
     public void abrePrincipal(){
              Principal a = new Principal();
              fecha();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fecha(){
        CadastrarProduto.getStage().close();
    } 
    
    private void cadastraProduto(){
        String nome = txNome.getText(),
               descri = txDescri.getText(),
               nicho = txNicho.getText(),
               status = txStatus.getText();
        String ordem = txOrdem.getText();
        String preco = txPreco.getText();
        
            Produto p = new Produto(nome,descri,nicho,status,ordem,preco);
            ProdutoDao dao = new ProdutoDao();
            if(dao.add(p)){
                abrePrincipal();
                fecha();
                Alert al = new Alert(AlertType.CONFIRMATION);
                al.setHeaderText("Produto Cadastrado!");
                al.show();
                
            }else{
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("Falha no cadastro!");
                al.show();
            }
    }
    
}
