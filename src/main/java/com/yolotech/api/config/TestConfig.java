package com.yolotech.api.config;

import com.yolotech.api.entities.Account;
import com.yolotech.api.entities.Category;
import com.yolotech.api.entities.Course;
import com.yolotech.api.entities.enums.AccRole;
import com.yolotech.api.entities.enums.CourseStatus;
import com.yolotech.api.repositories.AccountRepository;
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

  @Autowired private AccountRepository accountRepository;

  @Override
  public void run(String... args) throws Exception {
    Category category = new Category(null, "Front-End", true);
    Category category1 = new Category(null, "Back-End", true);
    Category category2 = new Category(null, "Full Stack", true);
    categoryRepository.saveAll(Arrays.asList(category, category1, category2));

    Account account =
        new Account(
            null,
            "Fabio Frasson",
            "Estudante de Java",
            "fabio.frass@gmail.com",
            "fabiofrasson",
            "Bio test",
            "https://github.com/fabiofrasson",
            "https://www.linkedin.com/in/fabiofrasson/",
            "123456",
            AccRole.ADMIN,
            Instant.parse("2021-05-09T18:24:30Z"),
            true);

    accountRepository.save(account);

    Account account1 =
        new Account(
            null,
            "Wilian Bueno",
            "Estudante de Python",
            "wil.bueno@gmail.com",
            "wilbueno",
            "Bio test",
            "https://github.com/wilbueno",
            "https://www.linkedin.com/in/wilbueno/",
            "123456",
            AccRole.COMPANYADMIN,
            Instant.parse("2021-05-09T18:24:30Z"),
            true);
    accountRepository.save(account1);

    Account account2 =
        new Account(
            null,
            "Kennedy Bueno",
            "Estudante de Lumion",
            "kennedy.bueno@gmail.com",
            "kenbueno",
            "Bio test",
            "https://github.com/kenbueno",
            "https://www.linkedin.com/in/kenbueno/",
            "123456",
            AccRole.STUDENT,
            Instant.parse("2021-05-09T18:24:30Z"),
            true);
    accountRepository.save(account2);

    Course course =
        new Course(
            null,
            "Front-End Completo",
            "Curso completo de front-end!",
            "João Amaral",
            account2,
            "https://www.frontendcompleto.com.br",
            250.0,
            35.0,
            "frontend-completo",
            Instant.parse("2021-05-08T20:46:05Z"),
            CourseStatus.PENDING,
            true,
            true);

    course.getCategoryList().add(category);

    courseRepository.save(course);

    Course course1 =
        new Course(
            null,
            "Back-End Completo",
            "Curso completo de back-end!",
            "Eduardo Ferreira",
            account2,
            "https://www.backendcompleto.com.br",
            350.0,
            55.0,
            "backend-completo",
            Instant.parse("2021-05-08T20:46:05Z"),
            CourseStatus.APPROVED,
            true,
            true);

    course1.getCategoryList().add(category1);
    courseRepository.save(course1);

    Course course2 =
        new Course(
            null,
            "Dev-Ops Completo",
            "Curso completo de dev-ops!",
            "Luciano Cabral",
            account2,
            "https://www.devopscompleto.com.br",
            550.0,
            75.0,
            "devops-completo",
            Instant.parse("2021-05-08T20:46:05Z"),
            CourseStatus.REJECTED,
            true,
            true);

    course2.getCategoryList().add(category2);
    courseRepository.save(course2);
  }
}
