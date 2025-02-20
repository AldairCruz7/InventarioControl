package com.inventariocontrol.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Entities.UserEntity;
import com.inventariocontrol.Utils.Views;

import java.util.UUID;

public class UserDTO {
    @JsonView(Views.Public.class)
    private UUID id;

    @JsonView(Views.Public.class)
    private String username;

    @JsonView(Views.Public.class)
    private String role;

    @JsonView(Views.Public.class)
    private String email;

    @JsonView(Views.Public.class)
    private String cellphoneNumber;

    public UserDTO(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.email = user.getEmail();
        this.cellphoneNumber = user.getCellphoneNumber();
    }
}
