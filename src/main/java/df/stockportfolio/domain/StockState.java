package df.stockportfolio.domain;

/**
 * This class represent a stock current state
 */
public class StockState extends Stock {

    private int value;

    public StockState(String name, int value) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

change;