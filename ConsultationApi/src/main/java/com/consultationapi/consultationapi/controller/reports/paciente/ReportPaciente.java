package com.consultationapi.consultationapi.controller.reports.paciente;

import com.consultationapi.consultationapi.data.reportes.paciente.ReadRecord;
import com.consultationapi.consultationapi.model.report.lab.Peticion;
import com.consultationapi.consultationapi.resources.ConstructionHistorialConsultas;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/reportePaciente/*")
public class ReportPaciente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConstructionHistorialConsultas constructionHistorialConsultas= new ConstructionHistorialConsultas();
        GsonUtils<ReadRecord> gsonUtils= new GsonUtils<>();
        GsonUtils<Peticion> gsonUtils1 = new GsonUtils<>();
        var peticion=gsonUtils1.readFromJson(req,Peticion.class);
        gsonUtils.sendAsJson(resp,constructionHistorialConsultas.construc(peticion.getId(), LocalDate.parse(peticion.getDateStart()), LocalDate.parse(peticion.getDateEnd())));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
