package com.consultationapi.consultationapi.controller.Login;

import com.consultationapi.consultationapi.data.login.Consultl;
import com.consultationapi.consultationapi.model.login.Login;
import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.resources.Encriptar;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login/*")
public class ControllerLogin extends HttpServlet {
    private  final GsonUtils<TypeUser> gsonUtils;
    private final Consultl consultl;
    public ControllerLogin(){
        gsonUtils= new GsonUtils<>();
        consultl= new Consultl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GsonUtils<Login> gsonUtilss=new GsonUtils<>();
        Encriptar encriptar = new Encriptar();
        Consultl consultar = new Consultl();
        var login =gsonUtilss.readFromJson(request, Login.class);
        System.out.println(login);
        var user = consultar.read(login);
        if(user==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        try {
            if(user.getPassword().equals(encriptar.hashPassword(login.getPassword()))){
                response.setStatus(HttpServletResponse.SC_OK);
                gsonUtilss.sendAsJson(response,user);
            }
            else{
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

}
