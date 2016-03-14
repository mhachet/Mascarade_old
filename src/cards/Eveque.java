package cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Eveque extends Card{

    private final int [] nbPlayersEveque = {4,5,6,7,8,9,10,11,12,13};

    public Eveque(){
        this.initialiseNbPlayers(nbPlayersEveque);
    }

    public int[] getNbPlayersEveque() {
        return nbPlayersEveque;
    }
}
