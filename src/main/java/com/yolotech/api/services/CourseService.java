package com.yolotech.api.services;

import com.yolotech.api.entities.Category;
import com.yolotech.api.entities.Course;
import com.yolotech.api.repositories.CategoryRepository;
import com.yolotech.api.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

  @Autowired private CourseRepository courseRepository;

  public List<Course> findAll() {
    return courseRepository.findAll();
  }

  public Course findById(Long id) {
    Optional<Course> optionalCourse = courseRepository.findById(id);
    return optionalCourse.get();
  }
}
