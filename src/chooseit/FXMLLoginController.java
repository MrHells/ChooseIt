/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chooseit;

import databases.userDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import tools.Login;

/**
 * FXML Controller class
 *
 * @author fhill
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private TextField txtNickname;
    @FXML
    private PasswordField txtPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public  void tryLogin(ActionEvent event) {
        //System.out.println(txtNickname.getText());
        Login.tryLogin(txtPass.getText(), txtNickname.getText());
    }

    @FXML
    private void verifyText(InputMethodEvent event) {
    }
    
}
