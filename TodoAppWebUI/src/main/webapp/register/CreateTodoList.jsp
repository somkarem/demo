<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>


<layout:html title="ToDo WebApp" subtitle="Task Creation">
	
	<form action="task-creation" name="regForm" id="regForm" method="post" class="form">
	
		<div tabindex="0" class="error-summary" id="errorBox" role="group" style="display:none">
	        <ul class="error-summary-list">	
	        </ul>
      	</div>
	
		<h3 class="heading-medium">Creating your task</h3>
	
		<div class="form-group">
			<label for="taskName">
				<span class="form-label-bold">Create a task</span>		
				<span class="error-message" id="error-message-task">Please enter a task</span>
    		</label>
    		<input class="form-control" id="taskName" type="text" name="taskName" value="<c:out value='${TodoListWebAppFormBean.taskName}'/>" aria-describedby="error-message-task"/>
  		</div>
  		
		<div class="form-group">
			<label for="taskDescription">
				<span class="form-label-bold">Task Description</span>				
				<span class="error-message" id="error-message-taskDescription">Please enter task description</span>
    		</label>
    		<input class="form-control" id="taskDescription" type="text" name="taskDescription" value="<c:out value='${TodoListWebAppFormBean.taskDescription}'/>" aria-describedby="error-message-taskDescription">
  		</div>
		<div class="form-group">
			<input type="submit" class="button" value="Submit" id="proc">		
		</div>	
	</form>
	
	<script>
	// to be done		
       </script>

</layout:html>
