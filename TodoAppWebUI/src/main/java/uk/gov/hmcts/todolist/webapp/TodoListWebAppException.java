package uk.gov.hmcts.todolist.webapp;

public class TodoListWebAppException extends Exception {

    private static final long serialVersionUID = 7167917183421664839L;

    public TodoListWebAppException()

    {
        super();
    }

    public TodoListWebAppException(String message)

    {

        super(message);

    }

    public TodoListWebAppException(Throwable cause) {

        super(cause);

    }

    public TodoListWebAppException(String message, Throwable cause)

    {

        super(message, cause);

    }

    public TodoListWebAppException(String message, Throwable cause,

    boolean enableSuppression, boolean writableStackTrace)

    {

        super(message, cause, enableSuppression, writableStackTrace);

    }

}
