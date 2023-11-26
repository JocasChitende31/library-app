package com.atendestartup.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendestartup.library.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
