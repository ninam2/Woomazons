package de.woomazons;

import de.woomazons.data.LabelRepository;
import de.woomazons.data.ShopRepository;
import de.woomazons.model.Label;
import de.woomazons.model.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class WooApplication {

    public static void main(String[] args) {
        SpringApplication.run(WooApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(LabelRepository labelRepository, ShopRepository shopRepository) {
        return args -> {
            Label lebensmittel = new Label(Constants.LEBENSMITTEL);
            Label drogerie = new Label(Constants.DROGERIEARTIKEL);
            labelRepository.save(lebensmittel);
            labelRepository.save(drogerie);

            log.info("Labels in repo:");
            for (Label label : labelRepository.findAll()
                    ) {
                log.info("Found label: {}", label.getName());

            }

            List<Label> lebensmittelEntity = labelRepository.findByName(Constants.LEBENSMITTEL);
            Shop edeka = new Shop("Edeka", lebensmittelEntity);
            Shop rewe = new Shop("Rewe", lebensmittelEntity);
            shopRepository.save(edeka);
            shopRepository.save(rewe);

            List<Label> drogerieEntity = labelRepository.findByName(Constants.DROGERIEARTIKEL);
            Shop rossmann = new Shop("Rossmann", drogerieEntity);
            Shop dm = new Shop("DM", drogerieEntity);
            shopRepository.save(rossmann);
            shopRepository.save(dm);


            log.info("Shops in repo:");
            for (Shop shop : shopRepository.findAll()
                    ) {
                log.info("Found shop: {}", shop.toString());

            }
        };
    }
}
