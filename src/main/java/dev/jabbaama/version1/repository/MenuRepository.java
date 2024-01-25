package dev.jabbaama.version1.repository;


import dev.jabbaama.version1.model.entities.Category;
import dev.jabbaama.version1.model.entities.Menu;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {


    boolean existsByNameMenuIgnoreCase(String name);
    boolean existsByCategoryId(Long id_category);

    Optional<Menu> findMenuByNameMenu(String name);
    Menu findMenuById(Long id_menu);
    Optional<Menu> findById(Long id_menu);
    List<Menu> findMenuByCategoryId(Long id);
    @Transactional
    void deleteByCategory(Category category);




}


