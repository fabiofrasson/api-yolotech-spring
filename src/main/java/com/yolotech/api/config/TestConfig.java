package com.yolotech.api.config;

import com.yolotech.api.entities.Category;
import com.yolotech.api.entities.Course;
import com.yolotech.api.repositories.CategoryRepository;
import com.yolotech.api.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired private CategoryRepository categoryRepository;

  @Autowired private CourseRepository courseRepository;

  @Override
  public void run(String... args) throws Exception {
    Category category = Category.builder().id(null).name("Front-End").isActive(true).build();
    Category category1 = Category.builder().id(null).name("Back-End").isActive(true).build();
    Category category2 = Category.builder().id(null).name("Full Stack").isActive(true).build();

    Course course =
        Course.builder()
            .id(null)
            .name("Front-End Completo")
            .description("Curso completo de front-end!")
            .instructor("João Amarante")
            .categoryList(Arrays.asList(category))
            .site("https://www.frontendcompleto.com.br")
            .price(250.0)
            .length(35.0)
            .slug("front-end-completo")
            .regDate(Instant.parse("2021-05-08T20:46:05Z"))
            .isEdited(true)
            .isActive(true)
            .build();
    Course course1 =
        Course.builder()
            .id(null)
            .name("Back-End Completo")
            .description("Curso completo de back-end!")
            .instructor("Eduardo Ferreira")
            .categoryList(Arrays.asList(category1))
            .site("https://www.backendcompleto.com.br")
            .price(350.0)
            .length(55.0)
            .slug("back-end-completo")
            .regDate(Instant.parse("2021-05-08T20:46:05Z"))
            .isEdited(true)
            .isActive(true)
            .build();
    Course course2 =
        Course.builder()
            .id(null)
            .name("Dev-Ops Completo")
            .description("Curso completo de dev-ops!")
            .instructor("Luciano Cabral")
            .categoryList(Arrays.asList(category2))
            .site("https://www.devopscompleto.com.br")
            .price(550.0)
            .length(75.0)
            .slug("devops-completo")
            .regDate(Instant.parse("2021-05-08T20:46:05Z"))
            .isEdited(true)
            .isActive(true)
            .build();

    categoryRepository.saveAll(Arrays.asList(category, category1, category2));
    courseRepository.saveAll(Arrays.asList(course, course1, course2));
  }
}
