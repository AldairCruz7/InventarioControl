package com.inventariocontrol.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.DTO.UserDTO;
import com.inventariocontrol.DTO.UserDetailedDTO;
import com.inventariocontrol.Entities.UserEntity;
import com.inventariocontrol.Services.UserService;
import com.inventariocontrol.Utils.Views;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @JsonView(Views.Public.class)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    @JsonView(Views.Detailed.class)
    public ResponseEntity<UserDetailedDTO> getUserById(@PathVariable UUID id) {
        UserEntity user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new UserDetailedDTO(user));
    }

   /* // Crear un usuario (201 Created)
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
        UserEntity newUser = userService.createUser(userDto);
        return ResponseEntity.status(201).body(new UserDTO(newUser));  // 201 Created
    }*/

    /*// Actualizar un usuario (200 OK o 404 Not Found)
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID id, @RequestBody UserDTO userDto) {
        UserEntity updatedUser = userService.updateUser(id, userDto);

        if (updatedUser == null) {
            return ResponseEntity.notFound().build();  // 404 Not Found si el usuario no existe
        }

        return ResponseEntity.ok(new UserDTO(updatedUser));  // 200 OK con el usuario actualizado
    }*/

  /*  // Eliminar un usuario (204 No Content o 404 Not Found)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        boolean deleted = userService.deleteUser(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();  // 404 Not Found si el usuario no existe
        }

        return ResponseEntity.noContent().build();  // 204 No Content si se eliminó correctamente
    }*/
}
