package df.stockportfolio.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class represent a stock current state
 */
@Document(collection = "StocksState")
public class StockState {

    @Id
    private String id;
    private String name;
    private int value;


    public StockState() {
        this.value = 0;
    }
    //@JsonCreator
    public StockState(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
