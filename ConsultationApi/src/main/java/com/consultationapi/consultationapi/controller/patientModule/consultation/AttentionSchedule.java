package com.consultationapi.consultationapi.controller.patientModule.consultation;

import com.consultationapi.consultationapi.controller.Controller;
import com.consultationapi.consultationapi.data.completeInformation.time.ReadTime;
import com.consultationapi.consultationapi.model.time.Hours;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;
import com.consultationapi.consultationapi.resources.GenerateSchedules;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AttentionSchedule/*")
public class AttentionSchedule extends HttpServlet {
    private GsonUtils<Hours> gsonUtils;
    private ArrayList<Hours> lista = new ArrayList<>();
    private Controller controller;
    public AttentionSchedule() {
        this.gsonUtils=new GsonUtils<>();
        lista = new ArrayList<>();
        this.controller=new Controller();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ReadTime readTime= new ReadTime();
        for(ScheduleDoctor  scheduleDoctor :  readTime.readList(controller.obtenerId(req,resp)) ){
            GenerateSchedules generateSchedules = new GenerateSchedules();
            this.buildSchedule(generateSchedules.scehdules(scheduleDoctor));
            System.out.println(generateSchedules.getListSchedule());
        }
        gsonUtils.sendAsJson(resp,this.lista);
        resp.setStatus(HttpServletResponse.SC_OK);
        this.lista.clear();
    }
    public ArrayList<Hours>  buildSchedule(List  list){
            for(int i=0; i< list.size() ;i++){
                try{
                    Hours hours = new Hours(list.get(i).toString(),list.get(i+1).toString());
                    this.lista.add(hours);
                }catch (Exception e){
                    System.out.println("error en: "+e);
                }
            }
            return lista;
    }
}
