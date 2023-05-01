package com.consultationapi.consultationapi.controller.user;

import com.consultationapi.consultationapi.controller.Controller;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.CreateIformationDoctor;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.ReadIformationDoctor;
import com.consultationapi.consultationapi.data.completeInformation.time.CreateTime;
import com.consultationapi.consultationapi.data.completeInformation.time.ReadTime;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/horariosAtencion/*")
public class HorarioAtencion extends HttpServlet {
    private GsonUtils<ScheduleDoctor> gsonUtils;
    private Controller controller;
    public HorarioAtencion(){
        gsonUtils= new GsonUtils<>();
        controller= new Controller();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ReadTime readTime= new ReadTime();
        int id = controller.obtenerId(req,resp);
        gsonUtils.sendAsJson(resp,readTime.readList(id));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateTime createTime= new CreateTime();
        var newHorario =  gsonUtils.readFromJson(req,ScheduleDoctor .class);
        System.out.println(newHorario);
        if(createTime.create(newHorario)==false){
            gsonUtils.sendAsJson(resp,newHorario);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
        else {
            gsonUtils.sendAsJson(resp,null);
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
