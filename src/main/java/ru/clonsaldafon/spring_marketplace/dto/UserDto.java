package ru.clonsaldafon.spring_marketplace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {

    @Email(message = "Введите корректный email")
    @NotBlank(message = "Email обязателен")
    @Size(max = 50, message = "Email не должен быть длиннее 50 символов")
    private String email;

    @NotBlank(message = "Пароль обязателен")
    @Size(min = 8, max = 16, message = "Пароль должен быть от 8 до 16 символов")
    private String password;

    @NotBlank(message = "Имя обязательно")
    @Size(max = 50, message = "Имя не должно быть длиннее 50 символов")
    private String name;

    @NotBlank(message = "Роль обязательна")
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
