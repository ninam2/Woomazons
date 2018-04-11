package de.woomazons;

import de.woomazons.data.LabelRepository;
import de.woomazons.data.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class WooApplication {

    public static void main(String[] args) {
        SpringApplication.run(WooApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(LabelRepository labelRepository, ShopRepository shopRepository) {
        return args -> {
            log.info("started:");
        };
    }
}
