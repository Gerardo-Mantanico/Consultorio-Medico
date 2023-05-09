package com.consultationapi.consultationapi.controller.patientModule.consultation;

import com.consultationapi.consultationapi.controller.Controller;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.ReadIformationDoctor;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/searchDorctors/*")
public class SearchdDoctors extends HttpServlet {
    private GsonUtils<CompleteInformation> gsonUtils;
    private Controller controller;
    public SearchdDoctors(){
        this.gsonUtils=new GsonUtils<>();
        this.controller= new Controller();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReadIformationDoctor readIformationDoctor= new ReadIformationDoctor();
        var listDoctores= readIformationDoctor.readlistDoctor(controller.obtenerId(req,resp));
        gsonUtils.sendAsJson(resp,listDoctores);

    }
}
