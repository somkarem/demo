package uk.gov.hmcts.todolist.webapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class GenericServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GenericServlet() {
        super();
    }

    protected static void postError(HttpServletRequest request,
            HttpServletResponse response, String url, String errMsg)
            throws IOException, ServletException {
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    protected static void postError(HttpServletRequest request,
            HttpServletResponse response, String url, String errMsg,
            String errorElementId) throws IOException, ServletException {
        postError(request, response, url, errMsg);
    }

    protected static void postError(HttpServletRequest request,
            HttpServletResponse response, String url) throws IOException,
            ServletException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    protected static String getSessionAttributeString(
            HttpServletRequest request, String paramName) {
        Object obj = request.getSession().getAttribute(paramName);
        if (obj != null)
            return obj.toString();
        else
            return null;
    }

    protected static String getRequestParameterString(
            HttpServletRequest request, String paramName) {
        Object obj = request.getParameter(paramName);
        if (obj != null)
            return obj.toString();
        else
            return null;
    }

    protected static void setSessionAttribute(HttpServletRequest request,
            String paramName, List<String> value) {
        ArrayList<String> val= (ArrayList<String>) value;
        request.getSession().setAttribute(paramName, val);
    }

    protected static void setSessionAttribute(HttpServletRequest request,
            String paramName, String value) {
        request.getSession().setAttribute(paramName, value);
    }
    
    protected static void setSessionAttribute(HttpServletRequest request,
            String paramName, long value) {
        Integer val = (int) value;
        request.getSession().setAttribute(paramName, val); 
    }
    
    protected static void setRequestParameter(HttpServletRequest request,
            String paramName, Object value) {
        request.setAttribute(paramName, value);
    }
}