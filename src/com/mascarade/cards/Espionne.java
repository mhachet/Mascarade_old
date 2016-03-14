package com.mascarade.cards;

/**
 * Created by melanie on 12/03/16.
 */


public class Espionne extends Card{
    private final int [] nbPlayersEspionne = {7,10,11,12,13};

    public Espionne(){
        this.initialiseNbPlayers(nbPlayersEspionne);
    }

    public int[] getNbPlayersEspionne() {
        return nbPlayersEspionne;
    }

}
