/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chooseit;

import Ask.Ask;
import static chooseit.MenuController.user;
import databases.AnswerDAO;
import databases.AskDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
    private Ask actualAsk;
    private int max, now;
    @FXML
    private TextArea txtStatement, txtCondition;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getValues();
        if (!asks.isEmpty()) {
            actualAsk = asks.get(0);
            max = asks.size();
        }
        now = 0;
        setValues();
    }

    public void setValues() {
        txtCondition.setText(actualAsk.getConditions());
        txtStatement.setText(actualAsk.getStatement());
    }

    public void getValues() {
        asks = askDao.searchAsk(user.getId());
        for (int i = 0; i < asks.size(); i++) {
            System.out.println(asks.get(i).getStatement());

            System.out.println(asks.get(i).getConditions());
        }
    }

    private void doUpdates(boolean button_clicked) {
        System.out.println(actualAsk.getIdAsk() + " || " + user.getId());
        try {
            save_answer(button_clicked);
            AnswerDAO.saveAnswer(user.getId(), actualAsk.getIdAsk());
            pop_alert();
        } catch (SQLException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        now += 1;
        if (now < max) {
            
            System.out.println(actualAsk.toString());
            actualAsk = asks.get(now);
            setValues();
        } else {
            //Mostra tela de n tem mais dilemas e fecha a janela
            System.out.println("Mostra tela de n tem mais dilemas e fecha a janela");
        }
    }

    @FXML
    private void btnNot_clicked(ActionEvent event) {
        doUpdates(false);
    }

    @FXML
    private void btnYes_clicked(ActionEvent event) {

        doUpdates(true);
    }

    public void save_answer(boolean button_pressed) throws SQLException {
        System.out.println("( ͡° ͜ʖ ͡°)-");
        if (button_pressed) {
            askDao.save_answer_yes();
        } else {
            askDao.save_answer_no();
        }
    }
    
    public void pop_alert(){
        float result = get_percentage_yes(); 
        
        if (result != 1000){
      
        String percentage_yes = (Float.toString(Math.round(result)));
        String percentage_no = (Float.toString(100 - Math.round(result)));
       
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("%" + percentage_yes + " das pessoas apertaram o botão \n"
                            + "%" + percentage_no + " Não apertaram");
        alert.showAndWait();
        
        } else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Você foi o primeiro a responder!");
            alert.showAndWait();
        }
    }
    
    public float get_percentage_yes(){  
        float total = (actualAsk.getNotQuant() + actualAsk.getYesQuant());
        if (total > 0){
            float result = ((actualAsk.getYesQuant() / total) * 100); 
            return result;
        } else {
            return 1000;
        }
    }
    
}
