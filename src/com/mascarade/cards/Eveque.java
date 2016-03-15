package com.mascarade.cards;

import com.mascarade.game.Player;
import com.mascarade.game.Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melanie on 12/03/16.
 */
public class Eveque extends Card{

    private final int [] nbPlayersEveque = {4,5,6,7,8,9,10,11,12,13};

    public Eveque(){
        this.initialiseNbPlayers(nbPlayersEveque);
    }

    /**
     *
     * The Eveque power allow to take 2 gold pieces to the richest player.
     * If equality between several players, the concerned player chose as he wants.
     */
    public void activePower(Player concernedPlayer, Bank bank){
        int maxMoney = this.findMaxMoneyOfPlayers(bank);
        List<Player> richestPlayer = this.findRichestPlayers(bank, maxMoney);
    }

    public int findMaxMoneyOfPlayers(Bank bank){
        ArrayList<Player> playerArrayList = bank.getListPlayers();
        int max = 0;
        for(int p = 0 ; p < playerArrayList.size() ; p++) {
            Player player = playerArrayList.get(p);
            int moneyPlayer = player.getNbMoney();
            if (max <= moneyPlayer) {
                max = moneyPlayer;
            }
        }

        return max;
    }

    public ArrayList<Player> findRichestPlayers(Bank bank, int maxMoney){
        ArrayList<Player> playerArrayList = bank.getListPlayers();
        ArrayList<Player> richestPlayers = new ArrayList<>();
        for(int p = 0 ; p < playerArrayList.size() ; p++){
            Player player = playerArrayList.get(p);
            int moneyPlayer = player.getNbMoney();
            if(maxMoney == moneyPlayer){
                richestPlayers.add(player);
            }
        }
        return richestPlayers;
    }

    public int[] getNbPlayersEveque() {
        return nbPlayersEveque;
    }


}
