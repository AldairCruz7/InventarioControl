package com.inventariocontrol.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Entities.DepartmentsEntity;
import com.inventariocontrol.Entities.UserEntity;
import com.inventariocontrol.Utils.Views;

public class UserDetailedDTO extends UserDTO {

    @JsonView(Views.Detailed.class)
    private DepartmentsEntity department;

    public UserDetailedDTO(UserEntity user) {
        super(user);
        this.department = user.getDepartment() != null ? user.getDepartment() : null;
    }

}
