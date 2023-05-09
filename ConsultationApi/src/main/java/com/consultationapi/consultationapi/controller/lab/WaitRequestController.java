package com.consultationapi.consultationapi.controller.lab;

import com.consultationapi.consultationapi.model.lab.requestWait.RequestWait;
import com.consultationapi.consultationapi.resources.ConstructionRequestWait;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestWait/*")
public class WaitRequestController extends HttpServlet {
    private GsonUtils<RequestWait> gsonUtils;
    public WaitRequestController(){
        this.gsonUtils= new GsonUtils<>();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConstructionRequestWait constructionRequestWait = new ConstructionRequestWait();
        gsonUtils.sendAsJson(resp,constructionRequestWait.costruction("10"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
