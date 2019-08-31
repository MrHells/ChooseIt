/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chooseit;

import Ask.Ask;
import static chooseit.MenuController.user;
import databases.AskDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tools.Archive;
import users.User;

/**
 * FXML Controller class
 *
 * @author fhill
 */
public class QuestionsCreationController implements Initializable {

    @FXML
    private Button btnSubmit;
    @FXML
    private TextField txtStatement;
    @FXML
    private TextField txtCondition;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void submit(ActionEvent event) {
        try {
            AskDAO.saveAsk(new Ask(txtStatement.getText(), txtCondition.getText(), 0, 0, user.getId()));
        } catch (SQLException ex){
            Logger.getLogger(QuestionsCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
