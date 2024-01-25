package dev.jabbaama.version1.rest.ressources;

import dev.jabbaama.version1.model.dto.MenuDto;
import dev.jabbaama.version1.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "http://localhost:4200")
public class MenuControllerRest {
    @Autowired
    MenuService menuService;

    @GetMapping("/{nom-categorie}/menus")
    public ResponseEntity<List<MenuDto>> getAllMenusByCategorie(@PathVariable(value = "nom-categorie") String nameCategory) {

        return ResponseEntity.ok(menuService.getAllMenusByCategorie(nameCategory));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<MenuDto>> getAllMenus() {

        return ResponseEntity.ok(menuService.AllMenus());
    }

    @PostMapping("/{nom-categorie}/create")
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<Long> addMenu(@PathVariable(value = "nom-categorie") String nameCategory, @RequestBody MenuDto menuDto) {
        return ResponseEntity.ok(menuService.addMenu(nameCategory, menuDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateMenu(@PathVariable(value = "id") Long id, @RequestBody MenuDto menuDto) {
        return ResponseEntity.ok(menuService.updateMenu(id, menuDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable("id") Long id) {
        return ResponseEntity.ok(menuService.getMenuById(id));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<Boolean> deleteMenuById(@PathVariable(value = "nom-menu") String nomMenu) {
        return ResponseEntity.ok(menuService.deleteMenu(nomMenu));
    }
    @DeleteMapping("/{categorieId}/delete")
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<Boolean> deletteCategoriesMenu(@PathVariable (value = "categorieId") long categorieId){
        return ResponseEntity.ok(menuService.deleteAllMenuOfTheCategory(categorieId));
    }

}


