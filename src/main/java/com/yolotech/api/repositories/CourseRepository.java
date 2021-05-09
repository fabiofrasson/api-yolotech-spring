package com.yolotech.api.repositories;

import com.yolotech.api.entities.Category;
import com.yolotech.api.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {}
