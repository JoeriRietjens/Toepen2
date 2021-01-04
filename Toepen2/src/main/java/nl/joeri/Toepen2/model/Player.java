package nl.joeri.Toepen2.model;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private String name;
    private String password;
    private int number;
    private List <Card> hand;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public Player(String name, String password, int number) {
        this.name = name;
        this.password = password;
        this.number = number;
        this.hand = new ArrayList<Card>();
    }
}
