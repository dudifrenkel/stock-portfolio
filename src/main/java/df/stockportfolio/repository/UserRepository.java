package df.stockportfolio.repository;

import df.stockportfolio.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "user", path = "user")
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}