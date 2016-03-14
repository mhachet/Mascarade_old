package com.mascarade.game;

import com.mascarade.cards.Card;

/**
 * Created by melanie on 13/03/16.
 */
public class Player {

    private int nbMoney = 6;
    private Card card;
    private String cardType = "";
    private int id = 0;

    public Player(int nbMoney, Card card, int id){
        this.card = card;
        this.nbMoney = nbMoney;
        this.id = id;
    }

    public int getNbMoney() {
        return nbMoney;
    }

    public void setNbMoney(int nbMoney) {
        this.nbMoney = nbMoney;
    }

    public String getTypeCard(){
        Card card = this.getCard();
        return card.getClass().getSimpleName();
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
        this.cardType = this.getTypeCard();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
