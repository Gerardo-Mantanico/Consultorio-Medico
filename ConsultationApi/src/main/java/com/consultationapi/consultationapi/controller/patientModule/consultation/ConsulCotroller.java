package com.consultationapi.consultationapi.controller.patientModule.consultation;

import com.consultationapi.consultationapi.model.consultation.Consultation;
import com.consultationapi.consultationapi.model.doctor.ver_consultas.SolicitudesPendientes;
import com.consultationapi.consultationapi.service.ConsultationService;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/consul/*")
public class ConsulCotroller extends HttpServlet {
    private GsonUtils<Consultation> gsonUtils;
    private ConsultationService consultationService;
    public ConsulCotroller (){
        this.gsonUtils= new GsonUtils<>();
        this.consultationService = new ConsultationService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var newConsul = gsonUtils.readFromJson(req,Consultation.class);
        this.consultationService.Cread(newConsul);
        gsonUtils.sendAsJson(resp,newConsul);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GsonUtils<SolicitudesPendientes> solicitudesPendientesGsonUtils = new GsonUtils<>();
        gsonUtils.sendAsJson(resp,consultationService.Solicitudes_pendienes(124));
        resp.setStatus(HttpServletResponse.SC_OK);
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
