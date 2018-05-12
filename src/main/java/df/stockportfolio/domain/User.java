
package df.stockportfolio.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "Users")
public class User {

//    private static AtomicLong gen = new AtomicLong();

    @Id
    private String id;
    private Map<String,Integer> stocks;

    public User() {
        this.stocks = new HashMap<>();
    }

    public User(Map<String,Integer> stocks) {
        this.stocks = stocks;
    }

    public String getId() {
        return id;
    }

    public Map getStocks() {
        return stocks;
    }

    public void setStocks(Map<String,Integer> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return super.toString()+id+" : "+stocks.toString();
    }
}
