package com.yolotech.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yolotech.api.entities.enums.CourseStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private String instructor;

  @ManyToMany
  @JoinTable(
      name = "course_category",
      joinColumns = @JoinColumn(name = "courseId"),
      inverseJoinColumns = @JoinColumn(name = "categoryId"))
  private List<Category> categoryList = new ArrayList<>();

  private String site;
  private Double price;
  private Double length;
  private String slug;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
      timezone = "GMT")
  private Instant regDate;

  private Integer courseStatus;

  private boolean isEdited;
  private boolean isActive;

  public Course() {}

  public Course(
      Long id,
      String name,
      String description,
      String instructor,
      List<Category> categoryList,
      String site,
      Double price,
      Double length,
      String slug,
      Instant regDate,
      CourseStatus courseStatus,
      boolean isEdited,
      boolean isActive) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.instructor = instructor;
    this.categoryList = categoryList;
    this.site = site;
    this.price = price;
    this.length = length;
    this.slug = slug;
    this.regDate = regDate;
    setCourseStatus(courseStatus);
    this.isEdited = isEdited;
    this.isActive = isActive;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getInstructor() {
    return instructor;
  }

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  public List<Category> getCategoryList() {
    return categoryList;
  }

  public void setCategoryList(List<Category> categoryList) {
    this.categoryList = categoryList;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getLength() {
    return length;
  }

  public void setLength(Double length) {
    this.length = length;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public Instant getRegDate() {
    return regDate;
  }

  public void setRegDate(Instant regDate) {
    this.regDate = regDate;
  }

  public CourseStatus getCourseStatus() {
    return CourseStatus.valueOf(courseStatus);
  }

  public void setCourseStatus(CourseStatus courseStatus) {
    if (courseStatus != null) {
      this.courseStatus = courseStatus.getCode();
    }
  }

  public boolean isEdited() {
    return isEdited;
  }

  public void setEdited(boolean edited) {
    isEdited = edited;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }
}
