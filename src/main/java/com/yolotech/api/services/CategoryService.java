package com.yolotech.api.services;

import com.yolotech.api.entities.Category;
import com.yolotech.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  @Autowired private CategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Long id) {
    Optional<Category> optionalCategory = categoryRepository.findById(id);
    return optionalCategory.get();
  }
}
