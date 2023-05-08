package com.projectsd.services;


import com.projectsd.services.model.Worker;
import com.projectsd.services.repository.WorkerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.util.Arrays;

import static com.projectsd.services.enumeration.Job.*;

@SpringBootApplication
public class ServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner run(WorkerRepository workerRepository) {
        return args -> {
            workerRepository.save(new Worker("Alex", "Mintas", "alexmintas@yahoo.ro", "0740933344", LocalDate.of(2002, 6, 20), TileSetter));
            workerRepository.save(new Worker("Oana", "Morar", "oanamorar@yahoo.ro", "0740344521", LocalDate.of(2001, 3, 18), Locksmith));
            workerRepository.save(new Worker("Mihai", "Mic", "mihaimic@yahoo.ro", "0726977211", LocalDate.of(1998, 1, 30), Plumber));
            workerRepository.save(new Worker("Cristina", "Titu", "cristinatitu@yahoo.ro", "0730946454", LocalDate.of(2001, 5, 26), Electrician));
        };
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization", "Access-Control-Allow-Origin",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
