package com.consultationapi.consultationapi.model.login;

import lombok.*;
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Login {
    private int id;
    private String email;
    private String password;
    private String type;
}
