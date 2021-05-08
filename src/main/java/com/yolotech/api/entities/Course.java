package com.yolotech.api.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private Long id;

  @Getter @Setter private String name;
  @Getter @Setter private String description;
  @Getter @Setter private String instructor;

  @ManyToMany
  @JoinTable(
      name = "course_category",
      joinColumns = @JoinColumn(name = "courseId"),
      inverseJoinColumns = @JoinColumn(name = "categoryId"))
  private List<Category> categoryList = new ArrayList<>();

  @Getter @Setter private String site;
  @Getter @Setter private Double price;
  @Getter @Setter private Double length;
  @Getter @Setter private String slug;
  @Getter @Setter private Instant moment;
  @Getter @Setter private boolean isEdited;
  @Getter @Setter private boolean isActive;
}
