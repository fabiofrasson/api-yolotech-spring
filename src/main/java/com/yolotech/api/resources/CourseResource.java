package com.yolotech.api.resources;

import com.yolotech.api.entities.Account;
import com.yolotech.api.entities.Category;
import com.yolotech.api.entities.Course;
import com.yolotech.api.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseResource {

  @Autowired private CourseService courseService;

  @GetMapping
  public ResponseEntity<List<Course>> findAll() {
    List<Course> categories = courseService.findAll();
    return ResponseEntity.ok().body(categories);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Course> findById(@PathVariable Long id) {
    Course category = courseService.findById(id);
    return ResponseEntity.ok().body(category);
  }

  @PostMapping
  public ResponseEntity<Course> insert(@RequestBody Course course) {
    course = courseService.insert(course);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getId()).toUri();
    return ResponseEntity.created(uri).body(course);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    courseService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
    course = courseService.update(id, course);
    return ResponseEntity.ok().body(course);
  }
}
