/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chooseit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fhill
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCadastro;
    @FXML
    private Label label;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private Button btnShowData;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logar(ActionEvent event) {
        
    }

    private void register(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cadastra(ActionEvent event) {        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void showData(ActionEvent event) {
    }



    
}
