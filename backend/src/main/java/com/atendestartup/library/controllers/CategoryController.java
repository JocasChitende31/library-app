package com.atendestartup.library.controllers;

import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.DTO.CategoryDTO;
import com.atendestartup.library.DTO.ReplacementDTO;
import com.atendestartup.library.services.BookService;
import com.atendestartup.library.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/categories")
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> data = this.categoryService.findAll();
        return data;
    }

    @GetMapping(value = "/{catId}/category")
    public CategoryDTO findCategoryById(@PathVariable Long catId) {
        CategoryDTO data = this.categoryService.findCategoryById(catId);
        return data;
    }

    @GetMapping(value = "/{catId}/books")
    public List<BookMinDTO> findBookListByCategoryId(@PathVariable Long catId) {
        List<BookMinDTO> data = this.bookService.findByListCategoryId(catId);
        return data;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        this.categoryService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

    @PostMapping(value = "/create/category")
    public ResponseEntity insertCategory(@RequestBody CategoryDTO body) {
        if (this.categoryService.findByGenre(body.genre()) != null)
            return ResponseEntity.badRequest().build();
        else
            this.categoryService.createCategory(body);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update/{catId}/category")
    public ResponseEntity update(@PathVariable Long catId, @RequestBody CategoryDTO body) {
        this.categoryService.updateCategory(catId, body);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/{catId}/category")
    public ResponseEntity delete(@PathVariable Long catId) {
        this.categoryService.deleteCategoryById(catId);
        return ResponseEntity.ok().build();


    }

}
