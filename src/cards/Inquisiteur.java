package cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Inquisiteur extends Card{

    private final int [] nbPlayersInquisiteur = {11,12,13};

    public Inquisiteur(){
        this.initialiseNbPlayers(nbPlayersInquisiteur);
    }

    public int[] getNbPlayersInquisiteur() {
        return nbPlayersInquisiteur;
    }

}
