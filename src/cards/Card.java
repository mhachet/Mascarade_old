package cards;

import java.util.ArrayList;

/**
 * Created by melanie on 12/03/16.
 */
public class Card {

    protected ArrayList<Integer> nbPlayers;

    public Card(){
    }

    public void initialiseNbPlayers(int [] nbPlayersTable){
        nbPlayers = new ArrayList<>();

        for (int i = 0; i < nbPlayersTable.length; i++){
            nbPlayers.add(nbPlayersTable[i]);
        }
    }

    public ArrayList<Integer> getNbPlayers() {
        return nbPlayers;
    }

    public void setNbPlayers(ArrayList<Integer> nbPlayers) {
        this.nbPlayers = nbPlayers;
    }
}
