package df.stockportfolio.repository;

import df.stockportfolio.domain.StockState;
import org.springframework.data.mongodb.repository.MongoRepository;


//@RepositoryRestResource(collectionResourceRel = "stock", path = "stock")
public interface StockStateRepository extends MongoRepository<StockState, String> {

}
