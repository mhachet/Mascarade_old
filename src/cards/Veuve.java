package cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Veuve extends Card {

    private final int [] nbPlayersVeuve = {12,13};

    public Veuve() {
        this.initialiseNbPlayers(nbPlayersVeuve);
    }

    public int[] getNbPlayersVeuve() {
        return nbPlayersVeuve;
    }
}
