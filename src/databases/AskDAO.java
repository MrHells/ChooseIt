/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Ask.Ask;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import users.User;

/**
 *
 * @author fhill
 */
public class AskDAO {

    private static Connection con = null;

    public void save_answer_yes() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE ask \n"
                + "SET yesQuant = yesQuant + 1\n"
                + "WHERE idAsk = 1;";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void save_answer_no() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE ask "
                + "SET notQuant = notQuant + 1 "
                + "WHERE idAsk = 1;";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public static void saveAsk(Ask ask) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO ask(statement, conditions, yesQuant, notQuant, id_creator) VALUES (?,?,?,?,?)";
        System.out.println("a");
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, ask.getStatement());
            stmt.setString(2, ask.getConditions());
            stmt.setInt(3, 0);
            stmt.setInt(4, 0);
            stmt.setInt(5, ask.getIdCreator());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }//( ͡° ͜ʖ ͡°)

    public List<Ask> searchAsk(int idUser) {
        String sqlLeft = "SELECT statement, conditions, yesQuant, notQuant, idAsk, answer.idUser FROM ask JOIN answer using(idAsk) where idUser = '" + idUser + "' group by idAsk";
        String sqlInner = "SELECT statement, conditions, yesQuant, notQuant,idAsk FROM ask";

        List<Ask> allAsks = new ArrayList();
        List<Ask> onlyAskedAsks = new ArrayList();
        try {
            con = (new ConnectionFactory()).getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sqlLeft); PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement(sqlInner)) {
            ResultSet rs = stmt.executeQuery();
            ResultSet rs2 = stmt2.executeQuery();
            String[] data = new String[5];
            while (true) {

                if (rs.next()) {
                    System.out.println(rs.getString("idAsk") + " AAA " + rs.getInt("idAsk"));

                    Ask s = new Ask(rs.getString("statement"), rs.getString("conditions"), rs.getInt("yesQuant"), rs.getInt("notQuant"), 0, rs.getInt("idAsk"));
                    System.out.println(s.getIdAsk());

                    onlyAskedAsks.add(s);
                } else if (rs2.next()) {
                    System.out.println(rs2.getString("idAsk") + " AAA " + rs2.getInt("idAsk"));

                    Ask s = new Ask(rs2.getString("statement"), rs2.getString("conditions"), rs2.getInt("yesQuant"), rs2.getInt("notQuant"),0, rs2.getInt("idAsk"));
                    System.out.println(s.getIdAsk());

                    allAsks.add(s);
                } else {
                    List<Ask> finalList = new ArrayList<Ask>();
                    for (Ask askAll : allAsks) {
                        int count = 0;
                        System.out.println(askAll.getIdAsk() + " AAAAAAAAAAAAAAA");
                        for (Ask onlyAsked : onlyAskedAsks) {
                            System.out.println(askAll.getIdAsk() + " | " + onlyAsked.getIdAsk());
                            if (askAll.getIdAsk() == onlyAsked.getIdAsk()) {
                                count += 1;
                            }
                        }
                        if (count == 0) {
                            finalList.add(askAll);
                        }
                    }
                    return finalList;
                }

            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }

    public static boolean verifyExistence(String Nickname) throws SQLException {
        String sql = "SELECT Nickname FROM chooseit_database.user WHERE Nickname = '" + Nickname + "'";
        boolean r = false;
        try {
            con = (new ConnectionFactory()).getConnection();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("I");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return r;
    }

}
