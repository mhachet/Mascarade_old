package com.mascarade.cards;

/**
 * Created by melanie on 12/03/16.
 */
public class Paysan extends Card {

    private final int [] nbPlayersPaysan = {8,9,10,11,12,13};

    public Paysan(){
        this.initialiseNbPlayers(nbPlayersPaysan);
    }

    public int[] getNbPlayersPaysan() {
        return nbPlayersPaysan;
    }
}
