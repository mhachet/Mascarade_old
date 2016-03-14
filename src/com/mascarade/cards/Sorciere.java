package com.mascarade.cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Sorciere extends Card{

    private final int [] nbPlayersSorciere = {5,6,7,8,9,10,11,12,13};

    public Sorciere (){
        this.initialiseNbPlayers(nbPlayersSorciere);
    }

    public int[] getNbPlayersSorciere() {
        return nbPlayersSorciere;
    }
}
