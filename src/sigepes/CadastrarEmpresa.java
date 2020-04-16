package sigepes;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CadastrarEmpresa extends Application {
    private static Stage stage; //Uma janela
   
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CadastrarEmpresa.fxml")); //Carega o FXML
       Scene scene = new Scene(root); //Coloca o FXML numa cena
       stage.setTitle("Cadastrar Empresa");
       stage.setScene(scene); //Coloca a cena em uma janela
       stage.show(); //Abre a janela
       setStage(stage);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CadastrarEmpresa.stage = stage;
    }
    
}
