package df.stockportfolio.repository;

import df.stockportfolio.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    public static final String UNKNOWN_ID_MSG = "Error: Unknown ID";
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return this.userRepository.findAll();
    }


    @PutMapping
    public String insert(@RequestBody User user){
        this.userRepository.insert(user);
        return user.getId();
    }

    @PostMapping
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }

    @PostMapping("/update-values/{id}")
    public String updateValues(@PathVariable ("id") String id,@RequestBody HashMap<String,Integer> chValues) {
        Optional<User> user = this.userRepository.findById(id);
        if ((Object)user != Optional.empty()) {
            User upUser = user.get();
            Set<Map.Entry<String, Integer>> chValSet = chValues.entrySet();
            Map<String, Integer> org = user.get().getStocks();
            for (Map.Entry<String, Integer> stock : chValSet) {
                if (org.containsKey(stock.getKey())) {
                    org.computeIfPresent(stock.getKey(), ((k, v) -> v + stock.getValue()));
                }
            }
            this.userRepository.save(upUser);
            return id;
        }
        return UNKNOWN_ID_MSG;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id){
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }

//    public void update1(@RequestBody String id, Map<String,Integer> upStocks){
//        Optional<User> user = this.userRepository.findById(id);
//        if (user!=null){
//            Set<Map.Entry<String,Integer>> upSet = upStocks.entrySet();
//            Map<String,Integer> org = user.get().getStocks();
//            for (Map.Entry<String,Integer> stock:upSet){
//                if (org.containsKey(stock.getKey())){
//                    org.computeIfPresent(stock.getKey(),((k,v)-> v + stock.getValue()));
//                }
//            }
//        }
//        this.userRepository.save(user.get());
//    }

}
