package nl.joeri.Toepen2.model;

public enum Value {
    Ten(10),
    Nine(9),
    Eight(8),
    Seven(7),
    Ace(6),
    King(5),
    Queen(4),
    Jack(3);

    private final int value;

    Value(int value) {
        this.value = value;
    }
    public int getValue() { return value; }
}



