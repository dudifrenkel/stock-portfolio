//package df.stockportfolio.repository;
//
//import df.stockportfolio.domain.StockState;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/stock-state")
//public class StockStateController {
//
//    private StockStateRepository stockStateRepository;
//
//    public StockStateController(StockStateRepository stockStateRepository) {
//        this.stockStateRepository = stockStateRepository;
//    }
//
//    @GetMapping("/all")
//    public List<StockState> getAll() {
//        return this.stockStateRepository.findAll();
//    }
//
//    @PutMapping
//    public StockState insert (@RequestBody StockState stock){
//        this.stockStateRepository.insert(stock);
//        return stock;
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete (@PathVariable("id") String id){
//        stockStateRepository.deleteById(id);
//    }
//}
