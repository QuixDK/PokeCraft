package ru.pokecraft.site.models.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDataPageResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private String thirdName;
    private String phoneNumber;
    private String emailAddress;
}
