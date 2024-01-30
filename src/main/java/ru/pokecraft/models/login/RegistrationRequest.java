package ru.pokecraft.models.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static ru.pokecraft.constants.ExceptionMessages.*;

@Data
public class RegistrationRequest {
    @NotBlank(message = blankUsernameExceptionMessage)
    @Size(min = 1, max = 25)
    @Pattern(regexp = "^(?=.*[a-zA-Z0-9])(?=\\S+$).{1,25}$", message = usernamePatternException)
    private String username;
    @NotBlank(message = blankPasswordExceptionMessage)
    @Size(min = 5, max = 64)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{5,64}$", message = passwordPatternException)
    private String password;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{5,64}$", message = passwordPatternException)
    @NotBlank(message = blankEmailExceptionMessage)
    @Size(min = 5, max = 64)
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}