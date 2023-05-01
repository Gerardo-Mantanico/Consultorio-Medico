package com.consultationapi.consultationapi.controller.user;

import com.consultationapi.consultationapi.controller.Controller;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.CreateIformationDoctor;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.ReadIformationDoctor;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/completarInformacion/*")
public class CompletarInformacion extends HttpServlet {
    private GsonUtils<CompleteInformation> gsonUtils;
    private Controller controller;
    public CompletarInformacion(){
        gsonUtils= new GsonUtils<>();
        controller= new Controller();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ReadIformationDoctor readIformationDoctor = new ReadIformationDoctor();
        int id = controller.obtenerId(req,resp);
        gsonUtils.sendAsJson(resp,readIformationDoctor.readlist(id));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateIformationDoctor createIformationDoctor = new CreateIformationDoctor();
        var newInformacion =  gsonUtils.readFromJson(req, CompleteInformation.class);
        if(createIformationDoctor.create(newInformacion)==false){
            gsonUtils.sendAsJson(resp,newInformacion);
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
