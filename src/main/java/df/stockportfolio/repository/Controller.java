package df.stockportfolio.repository;

import df.stockportfolio.domain.StockState;
import df.stockportfolio.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class Controller {

    private static final String UNKNOWN_ID_MSG = "Error: Unknown ID";
    private static final String TOTAL_VAL_MSG = "Your portfolio total value is: ";
    private static final String UNKNOWN_STRATEGY_MSG = "Error: Unknown strategy";
    private static final String PERFORMANCE = "Performance";
    private static final String M_STABLE = "Most-stable";
    private static final String BEST = "Best";

    private UserRepository userRepository;
    private StockStateRepository stockStateRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public Controller(UserRepository userRepository, StockStateRepository stockStateRepository) {
        this.userRepository = userRepository;
        this.stockStateRepository = stockStateRepository;
    }


    @GetMapping("/stock-state/all")
    public List<StockState> getAllState() {
        return this.stockStateRepository.findAll();
    }

    @PutMapping("/stock-state")
    public StockState insert(@RequestBody StockState stock) {
        this.stockStateRepository.insert(stock);
        return stock;
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }


    @PutMapping("/users")
    public String insert(@RequestBody User user) {
        this.userRepository.insert(user);
        return user.getId();
    }

    @PostMapping("/users")
    public String update(@RequestBody User user) {
        Optional<User> opUser = this.userRepository.findById(user.getId());
        if (opUser.isPresent()) {
            this.userRepository.save(user);
        }
        return UNKNOWN_ID_MSG;

    }

    @PostMapping("/users/update-values/{id}")
    public String updateValues(@PathVariable("id") String id, @RequestBody HashMap<String, Integer> chValues) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
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

    @GetMapping("/users/portfolio-value/{id}")
    public String getPortfolioVal(@PathVariable("id") String id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            int portVal = 0;
            List<StockState> stockStateList = this.stockStateRepository.findAll();
            Map<String, Integer> userStocks = user.get().getStocks();
            for (StockState stockstate : stockStateList) {
                if (userStocks.containsKey(stockstate.getName())) {
                    portVal += userStocks.get(stockstate.getName()) * stockstate.getValue();
                }
            }
            return (TOTAL_VAL_MSG + Integer.toString(portVal));
        }
        return UNKNOWN_ID_MSG;
    }

    @GetMapping("/users/portfolio-value/{id}/{strategy}")
    public String getRec(@PathVariable("id") String id, @PathVariable("strategy") String strategy) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            switch (strategy) {
                case PERFORMANCE:
                    break;
                case M_STABLE:
                    break;
                case BEST:
                    break;
                default:
                    return UNKNOWN_STRATEGY_MSG;

            }
        }
        return "";
    }

}
