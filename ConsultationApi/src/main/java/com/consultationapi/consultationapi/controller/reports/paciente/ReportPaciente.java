package com.consultationapi.consultationapi.controller.reports.paciente;

import com.consultationapi.consultationapi.data.reportes.paciente.ReadEspecia;
import com.consultationapi.consultationapi.data.reportes.paciente.ReadExam;
import com.consultationapi.consultationapi.data.reportes.paciente.ReadHistorialRecarga;
import com.consultationapi.consultationapi.data.reportes.paciente.ReadRecord;
import com.consultationapi.consultationapi.model.report.lab.Peticion;
import com.consultationapi.consultationapi.model.report.paciente.HistorialRecarga;
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
        String Patth= req.getPathInfo();
        String[] splits = Patth.split("/");
        int id= Integer.parseInt(splits[1]);
        GsonUtils<HistorialRecarga> gsonUtils2 = new GsonUtils<>();
        ReadHistorialRecarga readHistorialRecarga = new ReadHistorialRecarga();
        gsonUtils2.sendAsJson(resp,readHistorialRecarga.read(id));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GsonUtils<Peticion> gsonUtils1 = new GsonUtils<>();
        var peticion=gsonUtils1.readFromJson(req,Peticion.class);

        if(peticion.getType().equals("1")){
            ConstructionHistorialConsultas constructionHistorialConsultas= new ConstructionHistorialConsultas();
            GsonUtils<ReadRecord> gsonUtils= new GsonUtils<>();
            gsonUtils.sendAsJson(resp,constructionHistorialConsultas.construc(peticion.getId(), LocalDate.parse(peticion.getDateStart()), LocalDate.parse(peticion.getDateEnd())));
        }
        else if(peticion.getType().equals("2")) {
            GsonUtils<ReadEspecia> gsonUtils2 = new GsonUtils<>();
            ReadEspecia readEspecia = new ReadEspecia();
            gsonUtils2.sendAsJson(resp, readEspecia.read(peticion.getId(), LocalDate.parse(peticion.getDateStart()), LocalDate.parse(peticion.getDateEnd())));
        }
        else if(peticion.getType().equals("3")){
            GsonUtils<ReadEspecia> gsonUtils2 = new GsonUtils<>();
            ReadExam readExam = new ReadExam();
            gsonUtils2.sendAsJson(resp,readExam.read( peticion.getId(), LocalDate.parse(peticion.getDateStart()), LocalDate.parse(peticion.getDateEnd())));
        }
        else if(peticion.getType().equals("4")){
            GsonUtils<HistorialRecarga> gsonUtils2 = new GsonUtils<>();
            ReadHistorialRecarga readHistorialRecarga = new ReadHistorialRecarga();
            gsonUtils2.sendAsJson(resp,readHistorialRecarga.read(peticion.getId()));
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
