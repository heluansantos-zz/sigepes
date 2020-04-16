package Controler;

import DAO.EmpresaDao;
import Model.Empresa;
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
import sigepes.CadastrarEmpresa;
import sigepes.CadastrarPessoa;
import sigepes.Principal;


public class CadastrarEmpresaController implements Initializable {

    @FXML
    private TextField txCnpj;

    @FXML
    private Button btCadastrar;

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
            CadastrarEmpresa emp = new CadastrarEmpresa();
            fecha();
            abrePrincipal();
            
    });
        
    btCancelar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            abrePrincipal();
          }
    });  
    
    btCadastrar.setOnMouseClicked((MouseEvent e)->{
            cadastraEmpresa();
    });
        
    btCadastrar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              cadastraEmpresa();
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
        CadastrarEmpresa.getStage().close();
    }
    
     private void cadastraEmpresa(){
        String nome = txNome.getText(),
               cnpj = txCnpj.getText(),
               nicho = txNicho.getText(),
               descri = txDescri.getText();
        
            Empresa p = new Empresa(nome,cnpj,nicho,descri);
            EmpresaDao dao = new EmpresaDao();
            if(dao.add(p)){
                abrePrincipal();
                fecha();
                Alert al = new Alert(AlertType.CONFIRMATION);
                al.setHeaderText("Empresa Cadastrada!");
                al.show();
                
            }else{
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("Falha no cadastro!");
                al.show();
            }
    }
}
