package com.mascarade.cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Tricheur extends Card {

    private final int [] nbPlayersTricheur = {4,5,6,9,10,11,12,13};

    public Tricheur(){
        this.initialiseNbPlayers(nbPlayersTricheur);
    }

    public int[] getNbPlayersTricheur() {
        return nbPlayersTricheur;
    }
}
