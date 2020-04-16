package Controler;

import DAO.PessoaDao;
import Model.Pessoa;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sigepes.CadastrarServico;
import sigepes.ListarPessoa;
import sigepes.Principal;

public class ListarPessoaController implements Initializable {

    @FXML
    private Button btAtualizar;

    @FXML
    private TableColumn<Pessoa, String> clmNome;

    @FXML
    private Button btDeletar;

    @FXML
    private TableColumn<Pessoa,Long> clmId;

    @FXML
    private TableColumn<Pessoa, String> clmEmail;

    @FXML
    private Button btGerarRelatorio;
    
    @FXML
    private TableView<Pessoa> tabela;


    @FXML
    private Button btCancelar;
    
    private Pessoa selecionada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
    btCancelar.setOnMouseClicked((MouseEvent e)->{
            abrePrincipal();   
    });
        
    btCancelar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            abrePrincipal();
          }
    }); 
    
    btDeletar.setOnMouseClicked((MouseEvent e)->{
            deleta();
    });
        
    btDeletar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            deleta();
          }
    }); 
    btAtualizar.setOnMouseClicked((MouseEvent e)->{
            tabela.setItems(atualizarTabela());
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Tabela Atualizada com Sucesso!");
            a.show();
    });
        
    btAtualizar.setOnKeyPressed((KeyEvent e)->{
          if(e.getCode() == KeyCode.ENTER){
            tabela.setItems(atualizarTabela());
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Tabela Atualizada com Sucesso!");
            a.show();
          }
    }); 

    
    tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    selecionada = (Pessoa)newValue;
            }
    });
    }    
    
    public void initTable(){
        clmId.setCellValueFactory(new PropertyValueFactory("id"));
        clmNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clmEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tabela.setItems(atualizarTabela());
    }
    
    public ObservableList<Pessoa> atualizarTabela(){
        PessoaDao dao = new PessoaDao();
        return FXCollections.observableArrayList(dao.getList());
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
        ListarPessoa.getStage().close();
    }   
    
    public void deleta(){
        if(selecionada != null){
        PessoaDao dao = new PessoaDao();
        dao.delete(selecionada);
        Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Usuário Deletado com Sucesso!");
            a.show();
            tabela.setItems(atualizarTabela());
        }else{
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Selecione um Usuário");
            a.show();
        }
    }
    
}
