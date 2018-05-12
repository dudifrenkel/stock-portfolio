
package df.stockportfolio.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document
public class User {

//    private static AtomicLong gen = new AtomicLong();

    @Id
    private String id;
    private List<StockUser> stocks;

    public User( List<StockUser> stocks) {
        this.stocks = stocks;
    }

    public List getStocks() {
        return stocks;
    }

    public void setStocks(List<StockUser> stocks) {
        this.stocks = stocks;
    }

    public void updateQnt(List<StockUser> upList){
        Collections.sort(upList);
        Collections.sort(this.stocks);
        Iterator iter = this.stocks.iterator();
        StockUser curr;
        for (StockUser stock:upList) {
            while (iter.hasNext()){
                curr = (StockUser) iter.next();
                if ()
            }
            stock.getQuantity()
        }

    }

}
