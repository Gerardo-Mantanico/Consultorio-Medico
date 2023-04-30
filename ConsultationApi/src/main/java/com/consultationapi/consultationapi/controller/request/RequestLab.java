package com.consultationapi.consultationapi.controller.request;

import com.consultationapi.consultationapi.controller.Controller;
import com.consultationapi.consultationapi.data.request.lab.CreateRequestLab;
import com.consultationapi.consultationapi.data.request.lab.ListLab;
import com.consultationapi.consultationapi.data.request.lab.UpdataRequest;
import com.consultationapi.consultationapi.model.request.RequestExamType;
import com.consultationapi.consultationapi.model.specialtyExam.Specialty;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requesLab/*")
public class RequestLab extends HttpServlet {
    private GsonUtils<RequestExamType> gsonUtils;
    private Controller controller;
    public RequestLab(){
        gsonUtils=new GsonUtils();
        controller= new Controller();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        ListLab list=new ListLab();
        String path=request.getPathInfo();
        if(path==null || path.equals("/")) {
            controller.readList(request, resp, list.list());
        }
        else {
                int id= controller.obtenerId(request,resp);
                controller.read(resp,list.read(id));
        }
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateRequestLab createRequestLab = new CreateRequestLab();
        var newRequest = gsonUtils.readFromJson(req,RequestExamType.class);
        createRequestLab.create(newRequest);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        var requestExam =gsonUtils.readFromJson(request,RequestExamType.class);
        UpdataRequest updataRequest = new UpdataRequest();
        System.out.println("recibiendo objeto: "+requestExam);
        updataRequest.Update(requestExam);
        gsonUtils.sendAsJson(resp,requestExam);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.processPath(req,resp);
    }
}
