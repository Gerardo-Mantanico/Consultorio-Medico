package com.consultationapi.consultationapi.controller.specialty;

import com.consultationapi.consultationapi.controller.Controller;
import com.consultationapi.consultationapi.model.specialtyExam.Specialty;
import com.consultationapi.consultationapi.service.SpecialtyService;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/specialty/*")
public class SpecialtyController extends HttpServlet {

    private final SpecialtyService specialtyService;
    private final Controller controller;
    private final GsonUtils<Specialty> gsonUtils;
    public SpecialtyController(){
        specialtyService= new SpecialtyService();
        controller= new Controller();
        gsonUtils = new GsonUtils<>();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        controller.readList(request,response, specialtyService.readall());
       controller.read(response,specialtyService.read(controller.obtenerId(request,response)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        GsonUtils<Specialty> gsonUtilss=new GsonUtils<>();
        if (pathInfo == null || pathInfo.equals("/")) {
            var specialty = gsonUtilss.readFromJson(request, Specialty.class);
            specialtyService.crete( specialty);
            response.setStatus(HttpServletResponse.SC_CREATED);
            gsonUtilss.sendAsJson(response, specialty);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
