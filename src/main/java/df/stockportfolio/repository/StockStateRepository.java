package df.stockportfolio.repository;

import df.stockportfolio.domain.StockState;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StockStateRepository extends MongoRepository<StockState, String> {

}
