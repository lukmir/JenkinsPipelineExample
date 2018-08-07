package com.jenkinspipelineexample.controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/")
public class WelcomeServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        httpServletResponse.setContentType("text/html");

        try {
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.print("Hello World");
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
