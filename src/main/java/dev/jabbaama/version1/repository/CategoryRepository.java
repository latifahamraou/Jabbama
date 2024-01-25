package dev.jabbaama.version1.repository;


import dev.jabbaama.version1.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    boolean existsByName(String name);
    Optional <Category> findCategoryByName(String name);
    Optional <Category> findCategoryById(Long id);

}



