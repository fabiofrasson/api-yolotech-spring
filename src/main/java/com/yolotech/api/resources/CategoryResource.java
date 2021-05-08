package com.yolotech.api.resources;

import com.yolotech.api.entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  @GetMapping
  public ResponseEntity<Category> findAll() {
    Category category = Category.builder().id(1L).name("Front-End").isActive(true).build();
    return ResponseEntity.ok().body(category);
  }
}
