package uk.gov.hmcts.todolist.webapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import uk.gov.hmcts.todolist.webapp.TodoListWebAppException;

public class SessionExpiryFilter implements Filter {
    private static final Logger LOGGER = Logger
            .getLogger(SessionExpiryFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            process(request, response, chain);
        } catch (TodoListWebAppException e) {
            LOGGER.error("***** error *****" + e);
            request.getRequestDispatcher(
                    "register/TodoListWebAppTechnicalError.jsp").forward(request,
                    response);
        }
        return;
    }

    public void process(ServletRequest request, ServletResponse response,
            FilterChain chain) throws TodoListWebAppException {
        try {
            LOGGER.debug("####### Entering method process #######");
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = null;
            String uri = req.getRequestURI();
            if(uri.contains("/TodoApp/TaskList") && req.getSession(false) == null)
                session = req.getSession(true);
             else
                session = req.getSession(false);

            LOGGER.debug("####### session ####### " + session);
            LOGGER.debug("####### uri ####### " + uri);
            Cookie[] cookies = req.getCookies();
            if ((cookies != null) && (cookies.length > 0)) {
                LOGGER.debug("####### cookies present ####### ");
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    LOGGER.debug("####### cookie name/value ####### "+cookie.getName()+"  "+cookie.getValue());
                   
                }
            } else {
                LOGGER.debug("####### NO cookie present ####### ");
            }
            if (session != null ) {
                chain.doFilter(req, res);
            } else {
                if (uri.contains("TaskList")) {
                    if (uri.endsWith("TaskList")) {
                        if ("GET".equalsIgnoreCase(req.getMethod())) {
                            chain.doFilter(req, res);
                        }
                    } else {
                        request.getRequestDispatcher(
                                "register/TodoListWebAppTechnicalError.jsp").forward(
                                request, response);
                        return;
                    }
                } 
            }
        } catch (IOException | ServletException e) {
            LOGGER.error("***** error *****" + e);
            throw new TodoListWebAppException();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.debug("####### Entering method init not used #######");

    }

    @Override
    public void destroy() {
        LOGGER.debug("####### Entering method destroy not used #######");
    }
}