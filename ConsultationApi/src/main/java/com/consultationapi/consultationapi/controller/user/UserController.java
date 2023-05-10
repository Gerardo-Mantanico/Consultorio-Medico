package com.consultationapi.consultationapi.controller.user;
import com.consultationapi.consultationapi.data.completeInformation.information_doctor.ReadIformationDoctor;
import com.consultationapi.consultationapi.data.completeInformation.time.ReadTime;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;
import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.service.UserService;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/typeUser/*")
public class UserController extends HttpServlet {

    private final GsonUtils<TypeUser> gsonTypeUser;
    private final UserService userService;

    public UserController() {
        gsonTypeUser = new GsonUtils<>();
        userService= new UserService();
    }

    // GET TypeUser/
    // GET TypeUser/id

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        ReadTime readTime = new ReadTime();
        GsonUtils<ScheduleDoctor> gsonUtilsread=new GsonUtils<>();
        GsonUtils<CompleteInformation> gsonUtilsSpecialty =new GsonUtils<>();
        ReadIformationDoctor readIformationDoctor = new ReadIformationDoctor();
        if (pathInfo == null || pathInfo.equals("/")) {
            var typerUser = userService.readAll();
            gsonTypeUser.sendAsJson(response, typerUser);
            return;
        }
        int typerUserId = processPath(request, response);
        var horarios = readTime.readList(typerUserId);
        var specialty = readIformationDoctor.readlist(typerUserId);
        gsonTypeUser.sendAsJson(response, userService.perfil(typerUserId,horarios,specialty));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    // POST TypeUser/
    // POST TypeUser/id
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var newUser =gsonTypeUser.readFromJson(request,TypeUser.class);
            System.out.println("El objeto que recibimos es "+newUser);
            if(userService.createUser(newUser)==true){
                response.setStatus(HttpServletResponse.SC_CREATED);
                gsonTypeUser.sendAsJson(response,newUser);
            }
            else {
              response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

    }

    //PUT TyperUser
    //PUT TyperUser/id
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processPath(request, response);
        var typeUser = gsonTypeUser.readFromJson(request, TypeUser.class);
        userService.update(typeUser);
        response.setStatus(HttpServletResponse.SC_OK);
        gsonTypeUser.sendAsJson(response, typeUser);   
    }

    private int processPath(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        String studentId = splits[1];

        try {
            Integer.parseInt(studentId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return -1;
        }

        if (userService.read(Integer.parseInt(studentId)) == null) {

            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return -1;
        }
        return Integer.parseInt(studentId);
    }

}
