package ru.pokecraft.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pokecraft.exceptions.UsernameIsUsedException;
import ru.pokecraft.exceptions.WrongAuthParamException;
import ru.pokecraft.filters.jwt.JwtProvider;
import ru.pokecraft.models.client.user.UserData;
import ru.pokecraft.models.client.user.Users;
import ru.pokecraft.models.login.AuthRequest;
import ru.pokecraft.models.login.AuthResponse;
import ru.pokecraft.models.login.RegistrationRequest;
import ru.pokecraft.models.login.UserDataPageResponse;
import ru.pokecraft.service.UserDataService;
import ru.pokecraft.service.UserService;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private UserService userService;
    private JwtProvider jwtProvider;
    private UserDataService userDataService;

//    @GetMapping("/register")
//    public ResponseEntity<String> getMainUserPage() {
//        return ResponseEntity.badRequest().body("Wrong request");
//    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegistrationRequest request) {
        if (userService.findUserByUsername(request.getUsername()) != null) {
            throw new UsernameIsUsedException();
        }
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userService.saveUser(user);
//        UserData userData = new UserData();
//        userData.setUserId(user.getId());
//        userData.setFirstName(null);
//        userData.setLastName(null);
//        userData.setThirdName(null);
//        userData.setEmailAddress(user.getEmail());
//        userData.setPhoneNumber(null);
        return ResponseEntity.ok().body("Success registration");
    }

//    @GetMapping("/login")
//    public ResponseEntity<String> authPage() {
//        return ResponseEntity.ok().body("OK");
//    }

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody  @Valid AuthRequest request) {
        Users user = userService.findUserByUsernameAndPassword(request.getUsername(),request.getPassword());
        if (user == null) {
            throw new WrongAuthParamException();
        }
        //String token = jwtProvider.generateToken(user.getUsername());
        //user.setToken(token);
        return null;//AuthResponse(token, user.getId());
    }

    @GetMapping("/my{user_id}")
    public ModelAndView myPage(@PathVariable(name = "user_id") long userId) {
        Users user = userService.findUserById(userId);
        if (!jwtProvider.validateToken(user.getToken())) {
            return new ModelAndView("forward:/login");
        }
        UserData userData = userDataService.findUserById(userId);
        if (userData == null) {
            return new ModelAndView("forward:/createMy");
        }
        return new ModelAndView("forward:/my");
    }

}
