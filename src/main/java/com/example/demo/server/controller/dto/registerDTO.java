package com.example.demo.server.controller.dto;

import lombok.Data;

@Data
public class registerDTO {
    private String username;
    private String password;
    private int phonenum;
    private int email;
    private String city;
    private String gender;
    private int account;
    private int type;
}
