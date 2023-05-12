package com.consultationapi.consultationapi.controller.percentage;

import com.consultationapi.consultationapi.data.porcentage.CreatePorcentage;
import com.consultationapi.consultationapi.data.porcentage.ReadPercentage;
import com.consultationapi.consultationapi.data.porcentage.UpdatePercentage;
import com.consultationapi.consultationapi.data.searchId.SearchId;
import com.consultationapi.consultationapi.model.percentage.Percentage;
import com.consultationapi.consultationapi.state.State;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/percentage")
public class PercentageController extends HttpServlet {
    private GsonUtils<Percentage> gsonUtils;
    public PercentageController (){
       this.gsonUtils= new GsonUtils<>();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreatePorcentage createPercentage = new CreatePorcentage();
        ReadPercentage readPercentage = new ReadPercentage();
        System.out.println(readPercentage.read());
        gsonUtils.sendAsJson(resp,readPercentage.read());
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     CreatePorcentage createporcentage= new CreatePorcentage();
        SearchId searchId = new SearchId();
        UpdatePercentage updatePercentage = new UpdatePercentage();
     var newPorcentage = gsonUtils.readFromJson(req,Percentage.class);
        newPorcentage.setId(0);
        newPorcentage.setState(State.ACTIVO.name());
        newPorcentage.setStartDate(new Date());
        updatePercentage.updata(new Date(),searchId.IdMax("porcentaje"));
     if(createporcentage.create(newPorcentage)==true){
         gsonUtils.sendAsJson(resp,newPorcentage);
         resp.setStatus(HttpServletResponse.SC_OK);
     }
     else{
         resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
     }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
