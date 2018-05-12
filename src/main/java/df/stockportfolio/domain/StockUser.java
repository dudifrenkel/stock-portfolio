package df.stockportfolio.domain;

import java.util.Objects;

/**
 * This class represent a user owned stacks
 */
public class StockUser extends Stock implements Comparable<StockUser> {

    private int quantity;

    public StockUser(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int compareTo(StockUser other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockUser stockUser = (StockUser) o;
        return this.getName().equals(stockUser.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(quantity);
    }
}
