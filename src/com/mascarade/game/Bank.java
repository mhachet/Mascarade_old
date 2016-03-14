package com.mascarade.game;

import android.app.Activity;
import android.util.Log;
import com.mascarade.Mascarade.AccueilMascarade;
import com.mascarade.cards.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by melanie on 13/03/16.
 */
public class Bank {
    private static final String MASCARADE = "BANKCLASS";

    private int nbMoney = 1000;
    private ArrayList<Card> bankCardsListStart = new ArrayList<>();
    private ArrayList<Card> bankCardsCenter = new ArrayList<>();
    private ArrayList<Player> listPlayers = new ArrayList<>();

    private int nbPlayers = 0;

    public Bank(int nbPlayers){

        this.nbPlayers = nbPlayers;
    }

    public void initialiseCardsBank (){

        ArrayList<Card> listCardsGame = new ArrayList<>();

        if(nbPlayers < 4){
            System.err.println("Le nombre de jouers doit être au moins 4.");
        }
        else if (nbPlayers > 13){
            System.err.println("Le nombre de jouers maximal est 13.");
        }

        Juge juge = new Juge();
        Eveque eveque = new Eveque();
        Roi roi = new Roi();
        Reine reine = new Reine();

        listCardsGame.add(juge);
        listCardsGame.add(eveque);
        listCardsGame.add(roi);
        listCardsGame.add(reine);

        if(nbPlayers >= 8){
            Fou fou = new Fou();
            listCardsGame.add(fou);
        }
        if(nbPlayers == 4 || nbPlayers == 7 || nbPlayers == 13) {
            Voleur voleur = new Voleur();
            listCardsGame.add(voleur);
        }
        if(nbPlayers >= 5){
            Sorciere sorciere = new Sorciere();
            listCardsGame.add(sorciere);
        }
        if(nbPlayers == 7 || nbPlayers >= 10){
            Espionne espionne = new Espionne();
            listCardsGame.add(espionne);
        }
        if(nbPlayers >= 8){
            Paysan paysanFirst = new Paysan();
            Paysan paysanSecond = new Paysan();

            listCardsGame.add(paysanFirst);
            listCardsGame.add(paysanSecond);
        }
        if(nbPlayers != 7 && nbPlayers != 8){
            Tricheur tricheur = new Tricheur();
            listCardsGame.add(tricheur);
        }
        if (nbPlayers >= 11) {
            Inquisiteur inquisiteur = new Inquisiteur();
            listCardsGame.add(inquisiteur);
        }
        if(nbPlayers >= 12){
            Veuve veuve = new Veuve();
            listCardsGame.add(veuve);
        }

        this.setBankCardsListStart(listCardsGame);
    }

    public void initialiseNbPlayers(){
        int index = 1;
        ArrayList<Player> playersList = new ArrayList<>();

        while(index <= nbPlayers){
            Player player = new Player(6, new Card(), index);
            playersList.add(player);
            Log.d(MASCARADE, "joueur " + player.getId());
            index ++;
        }

        this.setListPlayers(playersList);
    }

    public void distributionCards(){
        ArrayList<Player> listPlayers = this.getListPlayers();
        ArrayList<Card> cardsList = this.getBankCardsListStart();
        ArrayList<Card> cardsListCenter = this.getBankCardsListStart();
        ArrayList<Card> cardsListRemove = new ArrayList<>();

        ArrayList<Integer> cardsDone = new ArrayList<>();
        Log.d(MASCARADE, "nb joueur : " + listPlayers.size());

        for(int p = 1 ; p <= listPlayers.size() ; p++){
            Player player = listPlayers.get(p-1);
            Random randomIndex = new Random();
            //int randomNum = rand.nextInt((max - min) + 1) + min;
            int indexRandom = 0;
            while(cardsDone.contains(indexRandom)){
                indexRandom = 1 + randomIndex.nextInt(nbPlayers);
                Log.d(MASCARADE, "random : " + indexRandom);
            }
            if(!cardsDone.contains(indexRandom)){
                Card card = cardsList.get(indexRandom);
                //Log.d(MASCARADE, "player : " + player.getId() + " __ " + card.getTypeCard() + "  => " + indexRandom);
                cardsDone.add(indexRandom);
                player.setCard(card);
                if(nbPlayers < 6){
                    //Log.d(MASCARADE, "Carte " + cardsListCenter.get(indexRandom).getTypeCard() + " ne va pas au centre");
                    cardsListRemove.add(card);
                    //Log.d(MASCARADE, "remove " + cardsListCenter.get(indexRandom).getTypeCard() + " " + indexRandom);
                    //Log.d(MASCARADE, "size : " + cardsListCenter.size());
                }
            }

            Log.d(MASCARADE, "Joueur " + player.getId() + " obtient la carte " + player.getTypeCard() + " " + indexRandom);
        }

        Log.d(MASCARADE, "Il y a " + nbPlayers + " joueurs donc les cartes suivantes vont au centre : ");
        if(nbPlayers < 6) {
            for (int i = 0; i < cardsList.size() ; i++) {
                Card card = cardsList.get(i);
                Log.d(MASCARADE,"card : " + card.getTypeCard());
               /*if(!cardsListRemove.contains(card)){
                    cardsListCenter.add(card);
                }*/
            }
            for(int c = 0; c < cardsListCenter.size(); c++){
                Log.d(MASCARADE, " -> " + cardsListCenter.get(c).getTypeCard());
            }
        }


    }

    public ArrayList<Player> getListPlayers() {
        return listPlayers;
    }

    public void setListPlayers(ArrayList<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public ArrayList<Card> getBankCardsCenter() {
        return bankCardsCenter;
    }

    public void setBankCardsCenter(ArrayList<Card> bankCardsCenter) {
        this.bankCardsCenter = bankCardsCenter;
    }

    public int getNbMoney() {
        return nbMoney;
    }

    public void setNbMoney(int nbMoney) {
        this.nbMoney = nbMoney;
    }

    public ArrayList<Card> getBankCardsListStart() {
        return bankCardsListStart;
    }

    public void setBankCardsListStart(ArrayList<Card> bankCardsListStart) {
        this.bankCardsListStart = bankCardsListStart;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }
}
