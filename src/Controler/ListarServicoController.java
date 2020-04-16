package Controler;

import DAO.ServicoDao;
import Model.Servico;
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
import sigepes.ListarServico;
import sigepes.Principal;


public class ListarServicoController implements Initializable {

    @FXML
    private TableColumn<Servico, String> clmOrdem;

    @FXML
    private TableView<Servico> tabela;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btDeletar;

    @FXML
    private TableColumn<Servico, String> clmDescri;

    @FXML
    private TableColumn<Servico, String> clmStatus;

    @FXML
    private TableColumn<Servico, String> clmId;

    @FXML
    private Button btGerarRelatorio;

    @FXML
    private TableColumn<Servico, String> clmTitulo;

    @FXML
    private Button btCancelar;
    
    private Servico selecionada;
    
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
    tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    selecionada = (Servico)newValue;
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
    }    
    
    public void initTable(){
        clmId.setCellValueFactory(new PropertyValueFactory("id"));
        clmTitulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        clmDescri.setCellValueFactory(new PropertyValueFactory("descri"));
        clmOrdem.setCellValueFactory(new PropertyValueFactory("ordem"));
        clmStatus.setCellValueFactory(new PropertyValueFactory("status"));
        tabela.setItems(atualizarTabela());
    }
    
    public ObservableList<Servico> atualizarTabela(){
        ServicoDao dao = new ServicoDao();
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
        ListarServico.getStage().close();
    }   
    public void deleta(){
        if(selecionada != null){
        ServicoDao dao = new ServicoDao();
        dao.delete(selecionada);
        Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Serviço Deletado com Sucesso!");
            a.show();
            tabela.setItems(atualizarTabela());
        }else{
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Selecione um Serviço");
            a.show();
        }
    }
}
