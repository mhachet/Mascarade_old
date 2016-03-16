package com.mascarade.Mascarade;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.mascarade.cards.Espionne;
import com.mascarade.cards.Eveque;
import com.mascarade.cards.Fou;
import com.mascarade.game.Bank;
import com.mascarade.game.Player;

import java.util.Random;

public class AccueilMascarade extends Activity {
    private static final String MASCARADE = "ACCUEIL";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int nbPlayers = 8;//this.generateNbPlayers();
        Bank newGame = new Bank(nbPlayers);
        newGame.initialiseCardsBank();
        newGame.initialiseNbPlayers();

        newGame.distributionCards();
        boolean exchange = true;
        //this.espionnePower(newGame, exchange);
        //this.evequePower(newGame);
        this.fouPower(newGame);
        TextView textView = new TextView(this);
        textView.setText("Le nombre de joueurs est : " + nbPlayers + ".\n" +
                "Les cartes en jeu sont : " + newGame.getBankCardsListStart());
        Log.d(MASCARADE, "Le nombre de joueurs est : " + nbPlayers + ".\n" +
                "Les cartes en jeu sont : " + newGame.getBankCardsListStart());
        setContentView(textView);
    }

    public void evequePower(Bank bank){
        Player playerEveque = bank.getPlayerWithCard("Eveque");
        Eveque eveque = (Eveque)playerEveque.getCard();
        Log.d(MASCARADE, "eveque est : " + playerEveque.getId() + "  " + playerEveque.getTypeCard());

        eveque.activePower(playerEveque, bank);

    }

    public void fouPower(Bank game){
        boolean changeCards = true;
        Player playerFou = game.getPlayerWithCard("Fou");
        Fou fou = (Fou)playerFou.getCard();
        Player firstPlayer = game.getRandomPlayer();
        Player secondPlayer = game.getRandomPlayer();
        while(firstPlayer.equals(playerFou)){
            firstPlayer = game.getRandomPlayer();
        }
        while(secondPlayer.equals(playerFou) || secondPlayer.equals(firstPlayer)){
            secondPlayer = game.getRandomPlayer();
        }
        fou.activePower(playerFou, firstPlayer, secondPlayer,changeCards);

    }
    public boolean espionnePower(Bank game, boolean exchange) {
        boolean exchangeDone = false;
        Player playerEspion = game.getPlayerWithCard("Espionne");
        Espionne espion = (Espionne)playerEspion.getCard();
        Log.d(MASCARADE, "espion est : " + playerEspion.getId() + "  " + playerEspion.getTypeCard());
        int idPlayerEspion = playerEspion.getId();
        Player opponentPlayer = null;
        if (idPlayerEspion < game.getListPlayers().size() - 1) {
            opponentPlayer = game.getListPlayers().get(idPlayerEspion + 1);
        } else {
            opponentPlayer = game.getListPlayers().get(idPlayerEspion - 1);
        }
        Log.d(MASCARADE, "playerOpponent : " + opponentPlayer.getId() + "  " + opponentPlayer.getTypeCard());
        espion.activePower(playerEspion, opponentPlayer, exchange);
        exchangeDone = true;


        return exchangeDone;
    }

    public int generateNbPlayers(){
        Random random = new Random();
        int nbPlayers = random.nextInt((13 - 4) + 1) + 4;

        return nbPlayers;
    }
}
