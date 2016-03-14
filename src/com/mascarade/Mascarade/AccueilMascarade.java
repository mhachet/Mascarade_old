package com.mascarade.Mascarade;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.mascarade.cards.Roi;
import com.mascarade.game.Bank;

import java.util.Random;

public class AccueilMascarade extends Activity {
    private static final String MASCARADE = "  MASCARADE_ACTIVITY";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int nbPlayers = 5;//this.generateNbPlayers();
        Bank newGame = new Bank(nbPlayers);
        newGame.initialiseCardsBank();
        newGame.initialiseNbPlayers();

        newGame.distributionCards();

        TextView textView = new TextView(this);
        textView.setText("Le nombre de joueurs est : " + nbPlayers + ".\n" +
                "Les cartes en jeu sont : " + newGame.getBankCardsListStart());
        Log.d(MASCARADE, "Le nombre de joueurs est : " + nbPlayers + ".\n" +
                "Les cartes en jeu sont : " + newGame.getBankCardsListStart());
        setContentView(textView);
    }

    public int generateNbPlayers(){
        Random random = new Random();
        int nbPlayers = random.nextInt((13 - 4) + 1) + 4;

        return nbPlayers;
    }
}
