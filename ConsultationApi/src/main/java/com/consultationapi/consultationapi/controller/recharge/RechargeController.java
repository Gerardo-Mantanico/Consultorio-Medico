package com.consultationapi.consultationapi.controller.recharge;

import com.consultationapi.consultationapi.model.Recharge.Recharge;
import com.consultationapi.consultationapi.service.RechargeService;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/recharge/*")
public class RechargeController extends HttpServlet {
    private GsonUtils<Recharge> gsonUtils;
    private RechargeService rechargeService;
    public RechargeController(){
        this.gsonUtils= new GsonUtils<>();
        this.rechargeService= new RechargeService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var newRecharge = gsonUtils.readFromJson(req,Recharge.class);
        System.out.println(newRecharge.toString());
        rechargeService.rechargePatien(newRecharge);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
