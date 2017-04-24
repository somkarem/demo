package uk.gov.hmcts.todolist.webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;


public class CreateTodoList extends GenericServlet {

    private static final long serialVersionUID = 1560689621037956822L;
    private static final Logger LOGGER = Logger
            .getLogger(CreateTodoList.class);

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        LOGGER.debug("####### Entering method doGet ####### ");
        request.getRequestDispatcher("register/CreateTodoList.jsp")
                .forward(request, response);
        return;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String taskName = request.getParameter(SessionAndRequestParams.TASKNAME);
        String taskDescription = request
                .getParameter(SessionAndRequestParams.TASKDESCRIPTION);
        String taskPriority = request.getParameter(SessionAndRequestParams.TASKPRIORITY);
        
        LOGGER.debug("TaskName is :"+taskName+ " Description: "+taskDescription+ "Priority is :"+taskPriority);
     
       //Call REST API to create task and store in DB
    
        response.sendRedirect("TaskCreationSuccess.jsp");
        return;
    }

 
}
