package com.consultationapi.consultationapi.controller.reports.lab;

import com.consultationapi.consultationapi.data.reportes.lab.ReadTopExam;
import com.consultationapi.consultationapi.model.report.admin.Top5;
import com.consultationapi.consultationapi.model.report.lab.Peticion;
import com.consultationapi.consultationapi.resources.Top5Pacienes;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/Top5Lab/*")
public class Top5LabController extends HttpServlet {
    private GsonUtils<Top5> gsonUtils;
    private Top5Pacienes top5Pacienes;
    private ReadTopExam readTopExam;
    public Top5LabController(){
        this.gsonUtils=new GsonUtils<>();
        this.top5Pacienes= new Top5Pacienes();
        this.top5Pacienes= new Top5Pacienes();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fechaTexto = "2023-05-07";
        LocalDate fecha = LocalDate.parse(fechaTexto);
        gsonUtils.sendAsJson(resp,top5Pacienes.construc(10,fecha,fecha));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GsonUtils<Peticion> gsonUtils1 = new GsonUtils<>();
        var request = gsonUtils1.readFromJson(req,Peticion.class);
        if(request.getType().equals("paciente")){
            gsonUtils.sendAsJson(resp,top5Pacienes.construc(request.getId(),LocalDate.parse(request.getDateStart()),LocalDate.parse(request.getDateEnd())));
        }
        else if(request.getType().equals("examen")) {
            ReadTopExam readTopExam1 = new ReadTopExam();
            gsonUtils.sendAsJson(resp, readTopExam1.read(request.getId(), LocalDate.parse(request.getDateStart()), LocalDate.parse(request.getDateEnd())));

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
