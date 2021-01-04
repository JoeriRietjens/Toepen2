package nl.joeri.Toepen2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>(Suit.values().length * Value.values().length);
    }

    public void reset(){
        for (Suit s : Suit.values()){
            for (Value v : Value.values()){
                Card c = new Card(s, v);
                cards.add(c);
            }
        }
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Card pop(){
        Card card = cards.get(0);
        cards.remove(card);
        return card;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
