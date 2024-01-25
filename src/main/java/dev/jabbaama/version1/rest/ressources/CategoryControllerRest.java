package dev.jabbaama.version1.rest.ressources;

import dev.jabbaama.version1.model.dto.CategoryDto;
import dev.jabbaama.version1.model.entities.Category;
import dev.jabbaama.version1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryControllerRest {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getall")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = new ArrayList<>();
        categories = categoryService.allCategories();
        return ResponseEntity.ok(categories);

    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.addCategory(categoryDto));
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<Boolean> updateCategorie(@PathVariable(value = "id") Long idCategory, @RequestBody CategoryDto categoryDto) {

        return ResponseEntity.ok(categoryService.updateCategory(idCategory, categoryDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDto> getCategorieById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @DeleteMapping("/delete/{nom-categorie}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Boolean> deleteCategorieById(@PathVariable(value = "nom-categorie") String nameCategory) {
        return ResponseEntity.ok(categoryService.deletecategory(nameCategory));
    }

}


