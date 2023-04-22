package com.consultationapi.consultationapi.controller.user;

import com.consultationapi.consultationapi.service.TypeExamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/typeExam/*")
public class TypeExamController extends HttpServlet {
    private final TypeExamService typeExamService;
    private final Controller controller;
    public TypeExamController(){
        typeExamService= new TypeExamService();
        controller=new Controller();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller.readList(request,response, typeExamService.readall());
        controller.read(response,typeExamService.read(controller.obtenerId(request,response)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
