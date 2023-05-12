package com.consultationapi.consultationapi.controller.lab.resultados;

import com.consultationapi.consultationapi.model.repuestaLab.Resultado;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/resultadosExam")
public class ResultadosExam extends HttpServlet {
    private GsonUtils<Resultado> gsonUtils;
    public ResultadosExam(){
        this.gsonUtils= new GsonUtils<>();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var listArchivos = gsonUtils.readFromJson(req,Resultado.class);

    }
}
