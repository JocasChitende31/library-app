package com.atendestartup.library.DTO;

import com.atendestartup.library.projections.AuthorProjection;
import com.atendestartup.library.entities.Author;

public record AuthorDTO(Long id, String name, String birthday, String nationality,String status) {
}
