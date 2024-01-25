package dev.jabbaama.version1.service;


import dev.jabbaama.version1.model.dto.CategoryDto;
import dev.jabbaama.version1.model.entities.Category;
import dev.jabbaama.version1.repository.CategoryRepository;
import dev.jabbaama.version1.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> allCategories(){
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());

    }

    public CategoryDto getCategory(Long id_categorie){
        return categoryRepository.findCategoryById(id_categorie).map(categoryMapper::toDto).get();
    }
    public Boolean deletecategory(String nameCategory) {
        Category category =  categoryRepository.findCategoryByName(nameCategory).orElseThrow(() -> new RuntimeException("code 101: le "));
        categoryRepository.deleteById(category.getId());
        return true;
    }
    public Boolean updateCategory(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("not found categorie with this id"));
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return true;
    }
    public Category addCategory(CategoryDto categoryDto) {
        checkNomAlreadyUsed(categoryDto);
        return categoryRepository.save(categoryMapper.toEntity(categoryDto));

    }
    private void checkNomAlreadyUsed(CategoryDto categoryDto) {
        if(categoryRepository.existsByName(categoryDto.getName())){
            throw new RuntimeException("Code 5268 : Il existe dejà une categorie avec ce nom");
        }
    }



}

