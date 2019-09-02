/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import Ask.Ask;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author fhill
 */
public class AnswerDAO {

    public static void saveAnswer(int idUser, int idAsk) throws SQLException {
        System.out.println(idAsk);
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO answer(idUser, idAsk, whenAnsered) VALUES (?,?,NOW())";
        System.out.println("a");
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, idUser);
            stmt.setInt(2, idAsk);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }//( ͡° ͜ʖ ͡°)
}
