package com.example.mtbs.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.mtbs.repository.MovieRepository;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return args -> {

        };
    }

}
