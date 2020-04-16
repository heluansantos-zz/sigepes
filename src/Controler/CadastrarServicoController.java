package Controler;

import DAO.ServicoDao;
import Model.Servico;
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
import sigepes.CadastrarServico;
import sigepes.Principal;


public class CadastrarServicoController implements Initializable {

    @FXML
    private TextField txStatus;

    @FXML
    private TextField txOrdem;

    @FXML
    private TextField txTitulo;

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField txDescri;

    @FXML
    private Button btCancelar;
   
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
           cadastraServico();
    });
        
    btCadastrar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              cadastraServico();
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
        CadastrarServico.getStage().close();
    }   
    
    private void cadastraServico(){
        String titulo = txTitulo.getText(),
               descri = txDescri.getText(),
               ordem = txOrdem.getText(),
               status = txStatus.getText();
        
            Servico p = new Servico(titulo,descri,ordem,status);
            ServicoDao dao = new ServicoDao();
            if(dao.add(p)){
                abrePrincipal();
                fecha();
                Alert al = new Alert(AlertType.CONFIRMATION);
                al.setHeaderText("Serviço Cadastrado!");
                al.show();
                
            }else{
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("Falha no cadastro!");
                al.show();
            }
    }
}
