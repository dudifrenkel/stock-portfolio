package df.stockportfolio.repository;

import df.stockportfolio.domain.StockState;
import df.stockportfolio.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DBSeeder implements CommandLineRunner{

    public static final String URL = "http://www.oracle.com/";
    private StockStateRepository stockStateRepository;
    private UserRepository userRepository;

    private static final String INIT_PATH = "C:\\Users\\Dudi\\Desktop\\Fyber\\stock-portfolio" +
                                                "\\src\\main\\java\\df\\stockportfolio\\repository\\";
    private static final int STOCK_NAME_PL = 0;
    private static final int VAL_PL = 1;

    public DBSeeder(StockStateRepository stockStateRepository, UserRepository userRepository) {
        this.stockStateRepository = stockStateRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        String st;
        String[] dataStr;
        StockState currStock;
        List<StockState> stockStateList = new ArrayList<>();

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

//        URL oracle = new URL(URL);
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(oracle.openStream()));
//
//        String inputLine;
//        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine);
//        in.close();
    }
}
