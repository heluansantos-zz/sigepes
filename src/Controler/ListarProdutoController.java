package Controler;

import DAO.ProdutoDao;
import Model.Produto;
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
import sigepes.ListarProduto;
import sigepes.Principal;

public class ListarProdutoController implements Initializable {

     @FXML
    private TableColumn<Produto, String> clmOrdem;

    @FXML
    private TableView<Produto> tabela;

    @FXML
    private Button btAtualizar;

    @FXML
    private TableColumn<Produto, String> clmNome;

    @FXML
    private Button btDeletar;

    @FXML
    private TableColumn<Produto, String> clmDescri;

    @FXML
    private TableColumn<Produto, String> clmStatus;

    @FXML
    private TableColumn<Produto, String> clmPreco;

    @FXML
    private TableColumn<Produto, String> clmId;

    @FXML
    private TableColumn<Produto, String> clmNicho;

    @FXML
    private Button btGerarRelatorio;

    @FXML
    private Button btCancelar;
    
    private Produto selecionada;

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
                    selecionada = (Produto)newValue;
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
        clmNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clmDescri.setCellValueFactory(new PropertyValueFactory("descri"));
        clmStatus.setCellValueFactory(new PropertyValueFactory("status"));
        clmNicho.setCellValueFactory(new PropertyValueFactory("nicho"));
        clmOrdem.setCellValueFactory(new PropertyValueFactory("ordem"));
        clmPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        tabela.setItems(atualizarTabela());
    }
    
    public ObservableList<Produto> atualizarTabela(){
        ProdutoDao dao = new ProdutoDao();
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
        ListarProduto.getStage().close();
    }   
    public void deleta(){
        if(selecionada != null){
        ProdutoDao dao = new ProdutoDao();
        dao.delete(selecionada);
        Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Produto Deletado com Sucesso!");
            a.show();
            tabela.setItems(atualizarTabela());
        }else{
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Selecione um Produto");
            a.show();
        }
    }
}