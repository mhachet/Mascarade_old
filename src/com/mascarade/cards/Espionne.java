package com.mascarade.cards;

import android.util.Log;
import com.mascarade.game.Player;

/**
 * Created by melanie on 12/03/16.
 */


public class Espionne extends Card{
    private final int [] nbPlayersEspionne = {7,10,11,12,13};
    private static final String ESPIONNE  = "ESPIONNE";

    public Espionne(){
        this.initialiseNbPlayers(nbPlayersEspionne);
    }

    public int[] getNbPlayersEspionne() {
        return nbPlayersEspionne;
    }

    /**
     *
     * The power of spy card is to see another player card
     * and his/her card in order to change (or not) theses two cards.
     *
     */
    public void activePower(Player concernedPlayer, Player opponent, boolean choicePlayer){
        Card concernedPlayerCard = concernedPlayer.getCard();
        Card opponentPlayerCard = opponent.getCard();

        concernedPlayerCard.setVisiblePlayer(true);
        opponentPlayerCard.setVisiblePlayer(true);

        // draw box to propose exchange
        // and retrieve player choice
        if(choicePlayer){
            Log.d(ESPIONNE, "player " + concernedPlayer.getId() + " : " + concernedPlayer.getTypeCard() + " opponent " + opponent.getId() + "  " + opponent.getTypeCard());

            Card tempCard = new Card();
            tempCard = opponentPlayerCard;
            opponent.setCard(concernedPlayerCard);
            concernedPlayer.setCard(tempCard);

            Log.d(ESPIONNE, "player " + concernedPlayer.getId() + ": " + concernedPlayer.getTypeCard() + " opponent " + opponent.getId() + " : " + opponent.getTypeCard());
        }

        concernedPlayerCard.setVisiblePlayer(false);
        opponentPlayerCard.setVisiblePlayer(false);

    }
}
