package nl.joeri.Toepen2.model;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new Deck();
        deck.reset();
        distributeCards();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void distributeCards(){
        for (int i = 0; i < 4; i++){
            player1.getHand().add(deck.pop());
        }

        for (int i = 0; i < 4; i++){
            player2.getHand().add(deck.pop());
        }
    }

    //TODO: Create function to compare two cards
    public void compareCards(Card cardA, Card cardB){

    }

}
