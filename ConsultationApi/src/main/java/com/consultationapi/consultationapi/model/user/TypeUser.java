package com.consultationapi.consultationapi.model.user;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class TypeUser extends User{
    private  String address;
    private int phone;
    private int cui;
}
