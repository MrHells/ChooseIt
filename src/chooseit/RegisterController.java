/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chooseit;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import tools.AlertSpawnOnly;
import tools.Register;

/**
 * FXML Controller class
 *
 * @author fhill
 */
public class RegisterController implements Initializable {

    @FXML
    private Button btnCadastro;
    @FXML
    private Label label;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtNickname;
    @FXML
    private PasswordField ptxtPassword;
    @FXML
    private PasswordField ptxtConfirmPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtName.setTooltip(new Tooltip("Your name need at least 3 characters and no more than 16"));
        txtNickname.setTooltip(new Tooltip("Your Nickname need at least 3 characters and no more than 16"));
        ptxtConfirmPassword.setTooltip(new Tooltip("Your password need at least 3 characters and only Alphabetic and Numbers"));
    }    

    @FXML
    private void cadastra(ActionEvent event){
        if(ptxtPassword.getText().equals(ptxtConfirmPassword.getText())){
            try {
                Register.registerUser(txtNickname.getText(), txtName.getText(), ptxtPassword.getText());
            } catch (SQLException ex) {
                AlertSpawnOnly.create_alert("You broken the GAME bro", "Crash", "I could not register you");
            }
        }else{
            AlertSpawnOnly.create_alert("Ops!", "Your passwords does't had a match... Sorry, dey tried.", "Your passoword and password confirmation are diferent.");
        }
    }
    
}
