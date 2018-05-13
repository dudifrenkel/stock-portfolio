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

    private StockStateRepository stockStateRepository;
    private UserRepository userRepository;

    private static final String INIT_PATH = "C:\\Users\\Dudi\\Desktop\\Fyber\\stock-portfolio" +
                                                "\\src\\main\\java\\df\\stockportfolio\\repository\\";
    private static final int STOCK_NAME_PL = 0;
    private static final int VAL_PL = 1;

//    public DBSeeder(StockStateRepository stockStateRepository) {
//        this.stockStateRepository = stockStateRepository;
//    }

//    public DBSeeder(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
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

        Map<String,Integer> umap = new HashMap<>();
        Map<String,Integer> umap1 = new HashMap<>();
        umap.put(stockStateList.get(0).getName(),5);
        umap.put(stockStateList.get(3).getName(),24);
        User us = new User(umap);
        umap1.put(stockStateList.get(50).getName(),1200);
        umap1.put(stockStateList.get(8).getName(),50);
        umap1.put(stockStateList.get(15).getName(),2);
        User us1 = new User(umap1);
        this.userRepository.deleteAll();
        this.userRepository.save(us);
        this.userRepository.save(us1);

        URL oracle = new URL("http://www.oracle.com/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();

    }
}
