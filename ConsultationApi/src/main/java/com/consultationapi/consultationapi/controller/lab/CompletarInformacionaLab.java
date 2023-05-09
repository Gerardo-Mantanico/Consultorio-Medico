package com.consultationapi.consultationapi.controller.lab;

import com.consultationapi.consultationapi.controller.Controller;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.CreateIformationDoctor;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.ReadIformationDoctor;
import com.consultationapi.consultationapi.data.completeInformation.information_lab.CreateIformationLab;
import com.consultationapi.consultationapi.data.completeInformation.information_lab.ReadIformationLab;
import com.consultationapi.consultationapi.data.completeInformation.information_lab.UpdateInformationlab;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/completarInformacionLab/*")
public class CompletarInformacionaLab extends HttpServlet {
    private GsonUtils<CompleteInformation> gsonUtils;
    private Controller controller;
    public CompletarInformacionaLab(){
        gsonUtils= new GsonUtils<>();
        controller= new Controller();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReadIformationLab readIformationLab = new ReadIformationLab();
        int id = controller.obtenerId(req,resp);
        gsonUtils.sendAsJson(resp,readIformationLab.readlist(id));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var newExamen= gsonUtils.readFromJson(req,CompleteInformation.class);
        CreateIformationLab createInformationLab = new CreateIformationLab();
        if(createInformationLab.create(newExamen)==true){
            gsonUtils.sendAsJson(resp,newExamen);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
        else {
            gsonUtils.sendAsJson(resp,null);
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var newExamen= gsonUtils.readFromJson(req,CompleteInformation.class);
        System.out.println(newExamen);
        UpdateInformationlab updateInformationlab = new UpdateInformationlab();
        if( updateInformationlab.Update(newExamen) ==true){
            gsonUtils.sendAsJson(resp,newExamen);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
        else {
            gsonUtils.sendAsJson(resp,null);
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
