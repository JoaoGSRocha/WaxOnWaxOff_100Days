package com.joaogsrocha._SpringREST.skin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {
    private static final Logger log =
            LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(SkinRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Skin("Item Skin 01", 9.0)));
            log.info("Preloading " + repository.save(new Skin("Item Skin 02", 19.0)));
        };
    }

}
