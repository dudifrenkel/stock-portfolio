package df.stockportfolio.repository;

import df.stockportfolio.domain.StockState;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DBSeeder implements CommandLineRunner{

    private StockStateRepository stockStateRepository;

    public static final String INIT_PATH = "C:\\Users\\Dudi\\Desktop\\Fyber\\stock-portfolio" +
                                                "\\src\\main\\java\\df\\stockportfolio\\repository\\";
    public static final int STOCK_NAME_PL = 0;
    public static final int VAL_PL = 1;

    public DBSeeder(StockStateRepository stockStateRepository) {
        this.stockStateRepository = stockStateRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        String st;
        String[] dataStr;
        StockState currStock;
        List<StockState> stockStateList = new ArrayList<>();
        Map<String,Integer> map;
        try {
            File file = new File(INIT_PATH + "stocks_init.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null) {
                dataStr = (st.split(" "));
                currStock = new StockState(dataStr[STOCK_NAME_PL],Integer.parseInt(dataStr[VAL_PL]));
                stockStateList.add(currStock);
            }

            this.stockStateRepository.deleteAll();

            this.stockStateRepository.saveAll(stockStateList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
