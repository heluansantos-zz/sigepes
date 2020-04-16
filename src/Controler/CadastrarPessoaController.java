package Controler;

import DAO.PessoaDao;
import Model.Pessoa;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sigepes.CadastrarEmpresa;
import sigepes.CadastrarPessoa;
import sigepes.Login;
import sigepes.Principal;


public class CadastrarPessoaController implements Initializable {

     @FXML private PasswordField psSenha;
    @FXML private Button btCadastrar;
    @FXML private TextField txNome;
    @FXML private TextField txEmail;
    @FXML private Button btCancelar;
    @FXML private PasswordField psConfSenha;

    
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
            CadastrarPessoa pessoa = new CadastrarPessoa();
            cadastraPessoa();
            
    });
        
    btCadastrar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              cadastraPessoa();
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
        CadastrarPessoa.getStage().close();
    }
    
    private void cadastraPessoa(){
        String nome = txNome.getText(),
               email = txEmail.getText(),
               senha = psSenha.getText(),
               confirmacao = psConfSenha.getText();
        if(senha.equals(confirmacao)){
            Pessoa p = new Pessoa(nome,email,senha);
            PessoaDao dao = new PessoaDao();
            if(dao.add(p)){
                abrePrincipal();
                fecha();
                Alert al = new Alert(AlertType.CONFIRMATION);
                al.setHeaderText("Usuário Cadastrado!");
                al.show();
                
            }else{
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("Falha no cadastro!");
                al.show();
            }
    }else{
            Alert al = new Alert(AlertType.ERROR);
            al.setHeaderText("As senhas não coincidem!");
            al.show();
        }
    }
}
