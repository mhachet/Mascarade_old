package com.mascarade.cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Voleur extends Card {

    private final int [] nbPlayersVoleur = {4,7,13};

    public Voleur(){
        this.initialiseNbPlayers(nbPlayersVoleur);
    }
}
