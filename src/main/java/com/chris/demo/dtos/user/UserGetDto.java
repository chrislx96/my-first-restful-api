package com.chris.demo.dtos.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserGetDto {
    private UUID id;
    private String firstName;
    private String lastName;
}
