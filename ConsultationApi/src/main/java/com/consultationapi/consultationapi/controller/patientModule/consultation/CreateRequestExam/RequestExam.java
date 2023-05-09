package com.consultationapi.consultationapi.controller.patientModule.consultation.CreateRequestExam;

import com.consultationapi.consultationapi.data.CreateRequestExam.ReadModelExam;
import com.consultationapi.consultationapi.model.patient.ModelExam;
import com.consultationapi.consultationapi.model.patient.RequestEx;
import com.consultationapi.consultationapi.model.patient.contruc;
import com.consultationapi.consultationapi.service.CreateRequestService;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CreateRequestExam/*")
public class RequestExam extends HttpServlet {
    private  GsonUtils<RequestEx> gsonUtils;
    public  RequestExam(){
        this.gsonUtils= new GsonUtils<>();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GsonUtils<RequestEx> gsonUtils= new GsonUtils<>();
        contruc c = new contruc();
        gsonUtils.sendAsJson(resp,c.construccion());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateRequestService createRequestService = new CreateRequestService();
        var re=gsonUtils.readFromJson(req,RequestEx.class);
        System.out.println(" idlab "+re.getIdLab()+" idpaciente "+re.getIdPaciente());
        createRequestService.create(re);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
