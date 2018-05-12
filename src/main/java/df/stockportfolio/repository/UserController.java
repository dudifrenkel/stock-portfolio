package df.stockportfolio.repository;

import df.stockportfolio.domain.StockUser;
import df.stockportfolio.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public void insert(@RequestBody User user){
        this.userRepository.save(user);
    }

    public void update(@RequestBody String id, List<StockUser> stocks){
        Optional<User> user = this.userRepository.findById(id);
        if (user!=null){
            List<StockUser> org = user.get().getStocks();
            Collections.sort(org);
            Collections.sort(stocks);
            for (StockUser stock:org){


            }
        }
        user.setStocks(stocks);
    }

}
