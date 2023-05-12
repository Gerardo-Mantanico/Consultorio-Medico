package com.consultationapi.consultationapi.controller;
import com.consultationapi.consultationapi.readFile.Modelo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet("/files")
@MultipartConfig
public class Archivo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = req.getPart("archivoEntrada");
         try{
             String nombreArch= filePart.getSubmittedFileName();
             String path=this.getServletConfig().getServletContext().getRealPath("/fileInput");
             File directorio= new  File(path);
             if(!directorio.exists()){
                 directorio.mkdir();
             }
             filePart.write(path+"/"+nombreArch);
             File archivo= new File(path+"/"+nombreArch);
             System.out.println(archivo.toPath());
             Modelo modelo = new Modelo();
             modelo.read(archivo.getPath());
             response.setStatus(HttpServletResponse.SC_CREATED);
             //response.setContentType("application/json");


         }catch (IOException e){
             e.printStackTrace();
         }

    }


}