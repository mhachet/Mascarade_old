package com.mascarade.Mascarade;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.mascarade.cards.Card;
import com.mascarade.cards.Espionne;
import com.mascarade.cards.Roi;
import com.mascarade.game.Bank;
import com.mascarade.game.Player;

import java.util.List;
import java.util.Random;

public class AccueilMascarade extends Activity {
    private static final String MASCARADE = "ACCUEIL";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int nbPlayers = 7;//this.generateNbPlayers();
        Bank newGame = new Bank(nbPlayers);
        newGame.initialiseCardsBank();
        newGame.initialiseNbPlayers();

        newGame.distributionCards();
        boolean exchange = true;
        this.espionnePower(newGame, exchange);

        TextView textView = new TextView(this);
        textView.setText("Le nombre de joueurs est : " + nbPlayers + ".\n" +
                "Les cartes en jeu sont : " + newGame.getBankCardsListStart());
        Log.d(MASCARADE, "Le nombre de joueurs est : " + nbPlayers + ".\n" +
                "Les cartes en jeu sont : " + newGame.getBankCardsListStart());
        setContentView(textView);
    }

    public boolean espionnePower(Bank game, boolean exchange) {
        boolean exchangeDone = false;

        List<Player> playerList = game.getListPlayers();
        for (int i = 0; i < playerList.size(); i++) {
            if(!exchangeDone){
                Player player = playerList.get(i);
                Espionne espion = null;

                Card playerCard = player.getCard();
                String cardName = playerCard.getTypeCard();
                if (cardName.equals("Espionne")) {
                    espion = (Espionne) playerCard;
                    Log.d(MASCARADE, "espion est : " + player.getId() + "  " + player.getTypeCard());
                    Player opponentPlayer = null;
                    if (i < playerList.size() - 1) {
                        opponentPlayer = playerList.get(i + 1);
                    } else {
                        opponentPlayer = playerList.get(i - 1);
                    }
                    Log.d(MASCARADE, "playerOpponent : " + opponentPlayer.getId() + "  " + opponentPlayer.getTypeCard());
                    espion.activePower(player, opponentPlayer, exchange);
                    exchangeDone = true;
                }
            }

        }

        return exchangeDone;
    }

    public int generateNbPlayers(){
        Random random = new Random();
        int nbPlayers = random.nextInt((13 - 4) + 1) + 4;

        return nbPlayers;
    }
}
