package com.google.sps.servlets;

import com.google.gson.Gson;
import java.util.Map;
import java.util.HashMap;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class UserServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    Map<String, String> map = new HashMap<>();
    UserService userService = UserServiceFactory.getUserService();
    Gson gson = new Gson();
    String json;
    if (userService.isUserLoggedIn()) {
        // String userEmail = userService.getCurrentUser().getEmail();
        String urlToRedirectToAfterUserLogsOut = "/";
        String logoutUrl = userService.createLogoutURL(urlToRedirectToAfterUserLogsOut);
        map.put("flag", "true");
        map.put("url", logoutUrl);
        // System.out.println("is log in, " + logoutUrl);
        json = gson.toJson(map);
    } else {
        System.out.println("not log in");
        String urlToRedirectToAfterUserLogsIn = "/";
        String loginUrl = userService.createLoginURL(urlToRedirectToAfterUserLogsIn);
        map.put("flag", "false");
        map.put("url", loginUrl);
        json = gson.toJson(map);
    }
    response.getWriter().println(json);
  }
}