package com.uni.controllers;

import com.uni.daos.TeamDAO;
import com.uni.daos.TeamRequestDAO;
import com.uni.daos.UserDAO;
import com.uni.entities.ImUser;
import com.uni.dtos.LoginCredentials;
import com.uni.services.RegistrationService;
import com.uni.services.RegistrationServiceImpl;
import io.javalin.http.Context;
import io.javalin.plugin.openapi.annotations.*;

public class UserController {

    private RegistrationService registrationService;

    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void login(Context ctx){
        LoginCredentials credentials = ctx.bodyAsClass(LoginCredentials.class);
        ImUser user = registrationService.getUserFromLoginCredentials(credentials);
        ctx.sessionAttribute("user",user);
        ctx.json(user);
    };



}
