package df.stockportfolio.repository;

import df.stockportfolio.domain.StockState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock-state")
public class StockStateController {

    private StockStateRepository stockStateRepository;

    public StockStateController(StockStateRepository stockStateRepository) {
        this.stockStateRepository = stockStateRepository;
    }

    @GetMapping("/all")
    public List<StockState> getAll() {
        return this.stockStateRepository.findAll();
    }
}
