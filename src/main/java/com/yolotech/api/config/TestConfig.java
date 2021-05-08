package com.yolotech.api.config;

import com.yolotech.api.entities.Category;
import com.yolotech.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        Category category = Category.builder().id(null).name("Front-End").isActive(true).build();
        Category category1 = Category.builder().id(null).name("Back-End").isActive(true).build();
        Category category2 = Category.builder().id(null).name("Full Stack").isActive(true).build();

        categoryRepository.saveAll(Arrays.asList(category, category1, category2));
    }
}
