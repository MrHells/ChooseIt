/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chooseit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tools.Login;
import tools.Register;
import users.User;

/**
 *
 * @author Emili
 */
public class FXMLDocumentController_Game implements Initializable {
    
    @FXML
    private Button btnYes, btnNo;
    @FXML
    private TextField txtAge, txtName, txtQuestion;
    
    public void btnYesAction(ActionEvent event) {
        
    }
    
    public void btnNoAction(ActionEvent event) {
        
    }
    
    private User actualUser = null;
    
    public void cadastra(ActionEvent event) {
        Register.registerUser(txtName.getText(), txtAge.getText());
    }
    
    public void logar(ActionEvent event) {
        User bufferTestUser;
        bufferTestUser = Login.tryLogin(txtName.getText(), txtAge.getText());
        if(bufferTestUser != null){
            actualUser = bufferTestUser;
            System.out.println("GetIt");
        }
    }
    
    public void showData(ActionEvent event) {
        if(actualUser != null){
            System.out.println("Age: " + actualUser.getAge());
            System.out.println("Name: "+ actualUser.getName());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
