package com.user.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.user.project.model.User;
import com.user.project.repository.JDBCRepository;


@SpringBootApplication
public class JDBCApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private JDBCRepository userRepository;
 
    @Override
    public void run(String... args) throws Exception {
 /*
        logger.info("Inserting -> {}", userRepository.insert(new User(93953, "Ramsfesh", "23Fadatare", "street1","ramesh@gmail.com")));
        logger.info("Inserting -> {}", userRepository.insert(new User(4955, "Jdfohn", "234Cena", "street2","john@gmail.com")));
        logger.info("Inserting -> {}", userRepository.insert(new User(35972, "adsftony", "456stark", "street3","stark@gmail.com")));
 
        logger.info("Employee id  -> {}", userRepository.findById(1013352));


        userRepository.deleteById(1033453);
       

        logger.info("All users -> {}", userRepository.findAll());
         */
    }
 
    public static void main(String[] args) {
        SpringApplication.run(JDBCApplication.class, args);
    }
}
