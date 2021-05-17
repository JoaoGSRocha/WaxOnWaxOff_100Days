package com.joaogsrocha._SpringREST.payroll;

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
            log.info("Preloading " + repository.save(new Skin("Bilbo Baggins", "Factory New")));
            log.info("Preloading " + repository.save(new Skin("Frodo Baggins", "Field Tested")));
        };
    }

}
