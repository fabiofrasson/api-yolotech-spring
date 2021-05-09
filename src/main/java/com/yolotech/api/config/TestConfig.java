package com.yolotech.api.config;

import com.yolotech.api.entities.Category;
import com.yolotech.api.entities.Course;
import com.yolotech.api.entities.enums.CourseStatus;
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
        new Course(
            null,
            "Front-End Completo",
            "Curso completo de front-end!",
            "João Amaral",
            Arrays.asList(category),
            "https://www.frontendcompleto.com.br",
            250.0,
            35.0,
            "frontend-completo",
            Instant.parse("2021-05-08T20:46:05Z"),
            CourseStatus.PENDING,
            true,
            true);

    Course course1 =
        new Course(
            null,
            "Back-End Completo",
            "Curso completo de back-end!",
            "Eduardo Ferreira",
            Arrays.asList(category1),
            "https://www.backendcompleto.com.br",
            350.0,
            55.0,
            "backend-completo",
            Instant.parse("2021-05-08T20:46:05Z"),
            CourseStatus.APPROVED,
            true,
            true);

    Course course2 =
        new Course(
            null,
            "Dev-Ops Completo",
            "Curso completo de dev-ops!",
            "Luciano Cabral",
            Arrays.asList(category2),
            "https://www.devopscompleto.com.br",
            550.0,
            75.0,
            "devops-completo",
            Instant.parse("2021-05-08T20:46:05Z"),
            CourseStatus.REJECTED,
            true,
            true);

    categoryRepository.saveAll(Arrays.asList(category, category1, category2));
    courseRepository.saveAll(Arrays.asList(course, course1, course2));
  }
}
