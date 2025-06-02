package com.javarush.thekillersmod3servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null) {
            Object username = session.getAttribute("username");
            if (username != null) {
                resp.getWriter().println("Welcome " + username);
            } else {
                resp.getWriter().println("You are not logged in");
            }
        } else {
            resp.getWriter().println("Session expired. Log in again");
        }
    }
}
