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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tools.Login;
import users.User;

/**
 * FXML Controller class
 *
 * @author fhill
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtNickname;
    private PasswordField txtPass;
    @FXML
    private PasswordField ptxtPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
    }
    
    @FXML
    public  void tryLogin(ActionEvent event) {
        System.out.println(ptxtPass.getText());
        
        User user = Login.tryLogin(ptxtPass.getText(), txtNickname.getText());
        System.out.println(user.toString());
    }

    
}
