package dev.jabbaama.version1.service;

import dev.jabbaama.version1.model.dto.MenuDto;
import dev.jabbaama.version1.model.entities.Menu;
import dev.jabbaama.version1.repository.CategoryRepository;
import dev.jabbaama.version1.repository.MenuRepository;
import dev.jabbaama.version1.service.mapper.CategoryMapper;
import dev.jabbaama.version1.service.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<MenuDto> AllMenus() {
        return menuRepository.findAll().stream().map(menuMapper::toDto).collect(Collectors.toList());
    }

    public List <MenuDto> getAllMenusByCategorie(String categoryName){
        if(!categoryRepository.existsByName(categoryName)){
            throw new RuntimeException("not found categorie with name = " + categoryName );
        }
        var category= categoryRepository.findCategoryByName(categoryName).get();

          List <MenuDto> menuDtos = menuRepository.findMenuByCategoryId(category.getId()).stream().map(menuMapper::toDto).collect(Collectors.toList());
        return menuDtos;
    }
    public MenuDto getMenuById(Long id) {
        return  menuRepository.findById(id).map(menuMapper::toDto).get();

    }

    public Long addMenu(String nameCategory, MenuDto menuDto){
        checkNomAlreadyUsed(menuDto);
       // checkCategory(idCategorie);
        Menu menu = menuMapper.toEntity(menuDto);
        categoryRepository.findCategoryByName(nameCategory).map(
                category -> {menu.setCategory(category);
            return menuRepository.save(menu);}).orElseThrow(()-> new RuntimeException("Not found categorie with name=" +nameCategory));

        return menu.getId();
    }

    public Boolean deleteMenu(String nameMenu) {
        Menu menu = menuRepository.findMenuByNameMenu(nameMenu).orElseThrow(() -> new RuntimeException("code 101: le "));
        menuRepository.deleteById(menu.getId());
        return true;
    }
    public Boolean updateMenu(Long id, MenuDto menuDto) {
        Menu menu=  menuRepository.findById(id).orElseThrow(() -> new RuntimeException("code 101: aucun menu avec ce id trouvé "));
        menu.setNameMenu(menuDto.getNameMenu());
        menu.setDescription(menu.getDescription());
        menu.setPhoto(menu.getPhoto());
        menu.setPrice(menuDto.getPrice());
      //  menu.setCategory(categoryMapper.toEntity(menuDto.getCategoryDto()));
        menuRepository.save(menu);
        return true;
    }
    public Boolean deleteAllMenuOfTheCategory(Long idCategory){
        if (!categoryRepository.existsById(idCategory)) {
            throw new RuntimeException("Not found Tutorial with id = " + idCategory);
        }
        var category = categoryRepository.findById(idCategory).get();
        menuRepository.deleteByCategory(category);
        return true;
    }
    private void checkCategory(Long id){
        if (!categoryRepository.existsById(id)){
            throw new RuntimeException("Il n'existe pas une categorie de ce nom");
        }
    }
    private void checkNomAlreadyUsed(MenuDto menuDto) {
        if (menuRepository.existsByNameMenuIgnoreCase(menuDto.getNameMenu())) {
            throw new RuntimeException("Code 101 : Il existe dejà un menu de ce nom");
        }
    }
}


