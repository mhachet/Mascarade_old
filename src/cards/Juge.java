package cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Juge extends Card{

    private final int [] nbPlayersJuge = {4,5,6,7,8,9,10,11,12,13};

    public Juge(){
        this.initialiseNbPlayers(nbPlayersJuge);
    }

    public int[] getNbPlayersJuge() {
        return nbPlayersJuge;
    }
}
