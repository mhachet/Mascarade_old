package cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Fou extends Card {

    private final int [] nbPlayersFou = {4,5,6,7,8,9,10,11,12,13};

    public Fou (){
        this.initialiseNbPlayers(nbPlayersFou);
    }

    public int[] getNbPlayersFou() {
        return nbPlayersFou;
    }
}
