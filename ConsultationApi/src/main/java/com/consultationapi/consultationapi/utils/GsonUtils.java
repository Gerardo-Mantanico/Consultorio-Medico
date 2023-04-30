package com.consultationapi.consultationapi.utils;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class GsonUtils<T> {
    private final Gson gson;
    public GsonUtils(){
        gson = new Gson();
    }
    //metodo para enviar informacion convertido a formato json
    public void sendAsJson(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("application/json");
        String res = gson.toJson(object);
        var out= response.getWriter();
        out.println(res);
        System.out.println(res);
    }

    //meto  para convertir un Json a clase
    public T readFromJson(HttpServletRequest request, Class<T> classT) throws IOException{
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String linea;
        while ((linea=reader.readLine()) !=null) buffer.append(linea);
        String inforequest = buffer.toString();
        return gson.fromJson(inforequest, classT);
    }

}
