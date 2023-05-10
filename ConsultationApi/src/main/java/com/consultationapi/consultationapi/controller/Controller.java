package com.consultationapi.consultationapi.controller;

import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class Controller{
     private GsonUtils<Object> gsonUtils;
     public Controller(){
         gsonUtils=new GsonUtils<>();
     }

    public  boolean readList(HttpServletRequest request, HttpServletResponse response,List list) throws IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo==null || pathInfo.equals("/")) {
           gsonUtils.sendAsJson(response, list);
        }
        return false;
    }
    public int processPath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        String httpMethod = request.getMethod();

        if (httpMethod.equals("PUT") || httpMethod.equals("DELETE")) {
            if (pathInfo == null || pathInfo.equals("/")) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return -1;
            }
        }
        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return -1;
        }
        String id = splits[1];
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return -1;
        }
        return Integer.parseInt(id);
    }
    public int obtenerId(HttpServletRequest request, HttpServletResponse response) throws IOException {
         int id;
         String pathInfo = request.getPathInfo();
         return  id = processPath(request,response);
    }
    public void  read( HttpServletResponse response, Object objeto) throws IOException {
         if(objeto==null){
             response.sendError(HttpServletResponse.SC_NOT_FOUND);
             return;
         }
        response.setStatus(HttpServletResponse.SC_OK);
        gsonUtils.sendAsJson(response, objeto);
    }
}
