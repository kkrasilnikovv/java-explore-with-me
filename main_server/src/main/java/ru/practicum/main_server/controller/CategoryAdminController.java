package ru.practicum.main_server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.main_server.dto.CategoryDto;
import ru.practicum.main_server.dto.NewCategoryDto;
import ru.practicum.main_server.service.CategoryService;


@RestController
@RequestMapping(path = "/admin/categories")
@Slf4j
@RequiredArgsConstructor
public class CategoryAdminController {
    private final CategoryService categoryService;

    @PatchMapping
    public CategoryDto updateCategory(@Validated @RequestBody CategoryDto categoryDto) {
        log.info("update category");
        return categoryService.updateCategory(categoryDto);
    }

    @PostMapping
    public CategoryDto createCategory(@Validated @RequestBody NewCategoryDto newCategoryDto) {
        log.info("create category");
        return categoryService.createCategory(newCategoryDto);
    }

    @DeleteMapping("/{catId}")
    public void deleteCategory(@PathVariable Long catId) {
        log.info("deleteCategory {}", catId);
        categoryService.deleteCategory(catId);
    }
}
