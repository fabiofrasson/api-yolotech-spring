package com.yolotech.api.services;

import com.yolotech.api.entities.Course;
import com.yolotech.api.repositories.CourseRepository;
import com.yolotech.api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    return optionalCourse.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Course insert(Course course) {
    return courseRepository.save(course);
  }

  public void delete(Long id) {
    try {
      courseRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  public Course update(Long id, Course course) {
    Course courseEntity = courseRepository.getOne(id);
    updateData(courseEntity, course);
    return courseRepository.save(courseEntity);
  }

  private void updateData(Course courseEntity, Course course) {
    courseEntity.setName(course.getName());
    courseEntity.setDescription(course.getDescription());
    courseEntity.setInstructor(course.getInstructor());
    courseEntity.setSite(course.getSite());
    courseEntity.setPrice(course.getPrice());
    courseEntity.setLength(course.getLength());
    courseEntity.setSlug(course.getSlug());
    courseEntity.setActive(course.isActive());
  }
}
