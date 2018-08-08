package com.jenkinspipelineexample.controller;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;

public class WelcomeServletTest extends Mockito {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(printWriter);

        new WelcomeServlet().doGet(request, response);

        assertTrue(stringWriter.toString().equals("Hello World"));
    }

    @Test
    public void testServletException() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        when(response.getWriter()).thenThrow(new RuntimeException("not an io exception"));

        Exception returnedException = null;

        try {
            new WelcomeServlet().doGet(request, response);
        } catch (Exception ex) {
            returnedException = ex;
        }

        assertTrue(returnedException != null);
    }

    @Test
    public void checkPrintWriterIOException() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(printWriter).thenThrow(new IOException("io exception"));

        new WelcomeServlet().doGet(request, response);

        assertTrue(!printWriter.toString().contains("Hello World"));
    }
}
