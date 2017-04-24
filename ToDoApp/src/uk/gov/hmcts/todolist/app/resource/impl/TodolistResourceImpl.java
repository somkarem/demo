package uk.gov.hmcts.todolist.app.resource.impl;

import TodolistResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import uk.gov.hmcts.todoapp.model.CreateTask;
import uk.gov.hmcts.todoapp.model.DeleteTaskInput;
import uk.gov.hmcts.todoapp.model.Error;
import uk.gov.hmcts.todoapp.model.GetTask;
import uk.gov.hmcts.todoapp.model.PatchCollection;
import uk.gov.hmcts.todoapp.model.ValidationErrors;
import uk.gov.hmcts.todoapp.resource.support.PATCH;

@Path("todolist")
public class TodolistResourceImpl implements TodolistResource {

    /**
     * Create a new to-do list
     * 
     * @param entity
     *     
     */
    @Override
    @POST
    @Consumes("application/json")
    @Produces({
        "application/json"
    })
    TodolistResource.PostTodolistResponse postTodolist(CreateTask entity)
        throws Exception {
    	
    	return TodolistResource.PostTodolistResponse.withOK();
    	
    	
    }
    
    
    /**
     * Patch a specific task or memo
     * 
     * @param entity
     *     
     */
    @Override
    @PATCH
    @Consumes("application/json")
    @Produces({
        "application/json"
    })
    TodolistResource.PatchTodolistResponse patchTodolist(PatchCollection entity)
        throws Exception {
    	
    	return TodolistResource.PatchTodolistResponse.withOK();
    	
    }
    
    
    /**
     * Remove a specific to-do list
     * 
     * @param entity
     *     
     */
    @Override
    @DELETE
    @Consumes("application/json")
    @Produces({
        "application/json"
    })
    TodolistResource.DeleteTodolistResponse deleteTodolist(DeleteTaskInput entity)
        throws Exception {
    	return TodolistResource.DeleteTodolistResponse.withOK();
    	
    }
    
    

}
