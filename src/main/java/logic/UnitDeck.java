package logic;

import java.util.ArrayList;
import java.util.Iterator;

public class UnitDeck {
    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    //constructors
    public UnitDeck(String deckName){
        setDeckName(deckName);
        this.cardsInDeck = new ArrayList<>();
    }

    //methods
    public void addCard(UnitCard newCard , int count){
        if(count<=0) return;

        for(CardCounter x:cardsInDeck){
            if(newCard.equals(x.getCard())){
                x.setCount(x.getCount() + count);
                return;
            }
        }

        cardsInDeck.add(new CardCounter(newCard , count));
    }

    public void removeCard(UnitCard toRemove , int count){
        if(count<=0 || !existsInDeck(toRemove)) return;

        Iterator<CardCounter> it = cardsInDeck.iterator();

        while(it.hasNext()) {
            CardCounter x = it.next();
            if (toRemove.equals(x.getCard())) {
                int remain = x.getCount() - count;

                if (remain > 0) x.setCount(remain);
                else it.remove();

                return;
            }
        }
    }

    public int cardCount(){
        int res = 0;
        for(CardCounter x:cardsInDeck){
            res += x.getCount();
        }
        return res;
    }

    public boolean existsInDeck(UnitCard card){

        for(CardCounter x:cardsInDeck){
            if(card.equals(x.getCard())) return true;
        }
        return false;
    }

    public boolean equals(UnitDeck other){
        return this.deckName.equals(other.getDeckName());
    }

    //getter
    public ArrayList<CardCounter> getCardsInDeck() {return cardsInDeck;}
    public String getDeckName() {return deckName;}

    //setter
    public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    public void setDeckName(String deckName) {
        if(deckName.isBlank()) this.deckName = "Untitled Deck";
        else this.deckName = deckName;
    }
}
