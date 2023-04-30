package com.consultationapi.consultationapi.controller.request;

import com.consultationapi.consultationapi.data.request.lab.ListLab;
import com.consultationapi.consultationapi.data.request.specialty.ListSpecialty;
import com.consultationapi.consultationapi.model.request.SpecialtyRequest;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Requests/*")
public class RequestSpecialty extends HttpServlet {
    private GsonUtils<SpecialtyRequest>  gsonUtils;
    public RequestSpecialty(){
        gsonUtils=new GsonUtils<>();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo=request.getPathInfo();
        String[] splits = pathInfo.split("/");
        String solicitud = splits[1];
        if(pathInfo==null || pathInfo.equals("/")){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        if (solicitud.equals("specialty")) {
            ListSpecialty read = new ListSpecialty();
            var list = read.list();
            gsonUtils.sendAsJson(resp, list);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        else if (solicitud.equals("lab")){
            ListLab read = new ListLab();
            var list = read.list();
            gsonUtils.sendAsJson(resp, list);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        else{
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
