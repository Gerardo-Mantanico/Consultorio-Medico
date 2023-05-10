package com.consultationapi.consultationapi.controller.request;

import com.consultationapi.consultationapi.data.request.specialty.CreateRequest;
import com.consultationapi.consultationapi.data.request.specialty.ListSpecialty;
import com.consultationapi.consultationapi.data.request.specialty.UpdateRequestSpecialty;
import com.consultationapi.consultationapi.data.specialty.CreateSpecialty;
import com.consultationapi.consultationapi.model.model.Especialidad;
import com.consultationapi.consultationapi.model.request.SpecialtyRequest;
import com.consultationapi.consultationapi.state.State;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RequestsSpecialty/*")
public class RequestSpecialty extends HttpServlet {
    private GsonUtils<SpecialtyRequest>  gsonUtils;
    public RequestSpecialty(){
        gsonUtils=new GsonUtils<>();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        ListSpecialty listSpecialty = new ListSpecialty();
        gsonUtils.sendAsJson(resp,listSpecialty.list());
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateRequest createRequest = new CreateRequest();
        var solicitud =gsonUtils.readFromJson(req, SpecialtyRequest.class);
        solicitud.setState(State.PENDIENTE_REVISION.name());
        solicitud.setId(0);
        System.out.println(solicitud);
        if(createRequest.create(solicitud)==true){
            gsonUtils.sendAsJson(resp,solicitud);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
        else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UpdateRequestSpecialty updateRequestSpecialty = new UpdateRequestSpecialty();
        var solicitud=gsonUtils.readFromJson(req,SpecialtyRequest.class);
        if(updateRequestSpecialty.Update(solicitud)==true){
            gsonUtils.sendAsJson(resp,solicitud);
            if(solicitud.getState().equals(State.ACEPTADO.name())){
                Especialidad specialty = new Especialidad();
                CreateSpecialty createSpecialty = new CreateSpecialty();
                specialty.setId(0);
                specialty.setNombre(solicitud.getName());
                specialty.setDescripcion(solicitud.getDescription());
                createSpecialty.create(specialty);
            }
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
