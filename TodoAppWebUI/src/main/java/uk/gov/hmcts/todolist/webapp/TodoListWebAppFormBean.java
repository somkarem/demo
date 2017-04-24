package uk.gov.hmcts.todolist.webapp;

import java.io.Serializable;

public class TodoListWebAppFormBean implements Serializable {

    private static final long serialVersionUID = -5356263702472129L;

    private String taskId;
    private String taskName;
    private String taskDescription;
    private String taskStatus;
    private String taskPriority;
    private String taskScheduleTimeStamp;
  
    
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskScheduleTimeStamp() {
        return taskScheduleTimeStamp;
    }

    public void setTaskScheduleTimeStamp(String taskScheduleTimeStamp) {
        this.taskScheduleTimeStamp = taskScheduleTimeStamp;
    }
}
