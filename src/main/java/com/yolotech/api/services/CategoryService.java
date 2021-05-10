package com.yolotech.api.services;

import com.yolotech.api.entities.Category;
import com.yolotech.api.repositories.CategoryRepository;
import com.yolotech.api.services.exceptions.DatabaseException;
import com.yolotech.api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    return optionalCategory.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Category insert(Category category) {
    return categoryRepository.save(category);
  }

  public void delete(Long id) {
    try {
      categoryRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
  }

  public Category update(Long id, Category category) {
    try {
      Category categoryEntity = categoryRepository.getOne(id);
      updateData(categoryEntity, category);
      return categoryRepository.save(categoryEntity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  private void updateData(Category categoryEntity, Category category) {
    categoryEntity.setName(category.getName());
    categoryEntity.setActive(category.isActive());
  }
}
