package com.yolotech.api.resources;

import com.yolotech.api.entities.Course;
import com.yolotech.api.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
