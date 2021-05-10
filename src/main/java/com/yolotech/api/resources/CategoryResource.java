package com.yolotech.api.resources;

import com.yolotech.api.entities.Category;
import com.yolotech.api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  @Autowired private CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> categories = categoryService.findAll();
    return ResponseEntity.ok().body(categories);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable Long id) {
    Category category = categoryService.findById(id);
    return ResponseEntity.ok().body(category);
  }

  @PostMapping
  public ResponseEntity<Category> insert(@RequestBody Category category) {
    category = categoryService.insert(category);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(category.getId())
            .toUri();
    return ResponseEntity.created(uri).body(category);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    categoryService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
    category = categoryService.update(id, category);
    return ResponseEntity.ok().body(category);
  }
}
