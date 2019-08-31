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
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author fhill
 */
public class GameController implements Initializable {
    private AskDAO askDao = new AskDAO();
    List<Ask> asks;
    @FXML
    private Button btnYes;
    @FXML
    private Button btnNot;
    @FXML
    private TextField txtStatement, txtCondition;
    @FXML
    private Circle btnChoose;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setValues();
    }
    public void setValues(){
        asks  = askDao.searchAsk(user.getId());
    }
    @FXML
    private void btnChoose_clicked(MouseEvent event) throws SQLException {
        boolean button_clicked = true;
        save_answer(button_clicked);
    }
    @FXML
    private void btnNot_clicked(ActionEvent event) throws SQLException {
        boolean button_clicked = false;
        save_answer(button_clicked);
    }
    public void save_answer(boolean button_pressed) throws SQLException {
        System.out.println("( ͡° ͜ʖ ͡°)-");
        if (button_pressed) {
            askDao.save_answer_yes();
        } else {
            askDao.save_answer_no();
        }
    }
}
