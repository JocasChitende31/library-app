package com.atendestartup.library.DTO;

import com.atendestartup.library.enums.UserRole;

public record RegisterDTO(String id, String login, String password, UserRole role) {
}
