package com.consultationapi.consultationapi.controller.user;

import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.model.user.User;
import com.consultationapi.consultationapi.service.AdminService;
import com.consultationapi.consultationapi.service.UserService;
import com.consultationapi.consultationapi.utils.GsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
    private final GsonUtils<User> gsonUser;
    private final AdminService  adminService;

    public AdminController() {
        gsonUser = new GsonUtils<>();
        adminService= new AdminService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            var user = adminService.readAll();
            gsonUser.sendAsJson(response, user);
            return;
        }
        int UserId = processPath(request, response);
        response.setStatus(HttpServletResponse.SC_OK);
        gsonUser.sendAsJson(response, adminService.read(UserId));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            var user = gsonUser.readFromJson(request, User.class);
            adminService.create(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
            gsonUser.sendAsJson(response, user);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
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
        String id = splits[1];

        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return -1;
        }

        if (adminService.read(Integer.parseInt(id)) == null) {

            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return -1;
        }
        return Integer.parseInt(id);
    }
}
