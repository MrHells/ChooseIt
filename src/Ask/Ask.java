/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ask;

/**
 *
 * @author fhill
 */
public class Ask {

    private int idAsk;
    private String statement;
    private String conditions;
    private int yesQuant;
    private int notQuant;
    private int idCreator;

    public Ask(String statement, String conditions, int yesQuant, int notQuant, int idCreator, int idAsk) {
        this.statement = statement;
        this.conditions = conditions;
        this.yesQuant = yesQuant;
        this.notQuant = notQuant;
        this.idCreator = idCreator;
        this.idAsk = idAsk;
    }

    public Ask(String statement, String conditions, int yesQuant, int notQuant) {
        this.statement = statement;
        this.conditions = conditions;
        this.yesQuant = yesQuant;
        this.notQuant = notQuant;
    }
    
    public int getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(int idCreator) {
        this.idCreator = idCreator;
    }

    public int getIdAsk() {
        return idAsk;
    }

    public void setIdAsk(int idAsk) {
        this.idAsk = idAsk;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getYesQuant() {
        return yesQuant;
    }

    public void setYesQuant(int yesQuant) {
        this.yesQuant = yesQuant;
    }

    public int getNotQuant() {
        return notQuant;
    }

    public void setNotQuant(int notQuant) {
        this.notQuant = notQuant;
    }
    
}
