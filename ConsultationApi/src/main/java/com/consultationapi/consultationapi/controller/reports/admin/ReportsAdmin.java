package com.consultationapi.consultationapi.controller.reports.admin;

import com.consultationapi.consultationapi.data.reportes.admin.histPorcentaje;
import com.consultationapi.consultationapi.model.report.admin.PercentageHistory;
import com.consultationapi.consultationapi.model.report.admin.Top5;
import com.consultationapi.consultationapi.resources.Top5Lab;
import com.consultationapi.consultationapi.resources.Top5Medicos;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/reportsAdmin/*")
public class ReportsAdmin extends HttpServlet {
    private Top5Medicos top5Medicos;
    private Top5Lab top5Lab;
    private GsonUtils<Top5> gsonUtils;
    public ReportsAdmin(){
        this.top5Medicos= new Top5Medicos();
        this.top5Lab= new Top5Lab();
        this.gsonUtils= new GsonUtils<>();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] splits = pathInfo.split("/");
        String id = splits[1];

        if (id.equals("medico")) {
            gsonUtils.sendAsJson(resp,top5Medicos.costruc());
        }
         else if(id.equals("historial")){
            GsonUtils<PercentageHistory> gsonUtils = new GsonUtils<>();
            histPorcentaje porcentaje= new histPorcentaje();
            gsonUtils.sendAsJson(resp,porcentaje.historial());

        }
        else {
            gsonUtils.sendAsJson(resp,top5Lab.costruc());
        }

    }
}
