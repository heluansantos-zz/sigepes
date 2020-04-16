package Controler;
import DAO.PessoaDao;
import Model.Pessoa;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sigepes.Login;
import sigepes.Principal;

public class LoginController implements Initializable {
    @FXML private Button btEntrar;
    @FXML private PasswordField txSenha;
    @FXML private Button btSair;
    @FXML private TextField txEmail;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btEntrar.setOnMouseClicked((MouseEvent e)->{
            entrar();
    });
        btSair.setOnMouseClicked((MouseEvent e)->{
            fecha();
    });
        
        btSair.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              fecha();
          }
          });  
        btEntrar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              entrar();
          }
          });  
        txSenha.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
              entrar();
          }
          });  
    }
      
    public void entrar(){
        if(txEmail.getText().equals("root") && txSenha.getText().equals("123")){
            Principal p = new Principal();
                fecha();
                try {
                    p.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }else{
        PessoaDao dao = new PessoaDao();
        List<Pessoa> pessoas = dao.getList();
        
        for(int x=0; x < pessoas.size(); x++){
            if(txEmail.getText().equals(pessoas.get(x).getEmail()) && txSenha.getText().equals(pessoas.get(x).getSenha())){
                Principal p = new Principal();
                x = pessoas.size();
                fecha();
                try {
                    p.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                if(x == pessoas.size()-1){
                Alert alert = new Alert (AlertType.ERROR);
                  alert.setTitle("Erro!");
                alert.setHeaderText("Login inválido!");
                alert.setContentText("Erro na autenticação do login!");
                alert.show();
                }
            }
        }
      }
         
    }
    public void fecha(){
        Login.getStage().close();
    }
}
