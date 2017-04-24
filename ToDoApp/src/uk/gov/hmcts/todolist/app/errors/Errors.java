package uk.gov.hmcts.todolist.app.errors;

import org.apache.commons.lang.StringUtils;
import uk.gov.hmcts.todoapp.model.Error;

public class Errors {

    public static Error create500Error(String code, String message){
        Error err = new Error();

        err.setMessage("Something is broken. Please contact the help desk");
        if(StringUtils.isNotEmpty(message)){
            err.setMessage(message);
        }

        if(StringUtils.isNotEmpty(code)){
            err.setCode(code);
        }
        return err;
    }

    public static Error create404Error(String code, String message){
        Error err = new Error();

        err.setMessage("The URI requested is invalid or the resource requested does not exist");
        if(StringUtils.isNotEmpty(message)){
            err.setMessage(message);
        }
        if(StringUtils.isNotEmpty(code)){
            err.setCode(code);
        }
        return err;
    }

    public static Error create422Error(String code, String message){
        Error err = new Error();

        err.setMessage("Unprocessable Entity");
        if(StringUtils.isNotEmpty(message)){
            err.setMessage(message);
        }
        if(StringUtils.isNotEmpty(code)){
            err.setCode(code);
        }
        return err;
    }

    public static Error create400Error(String code, String message){
        Error err = new Error();

        err.setMessage("The request was invalid.");
        if(StringUtils.isNotEmpty(message)){
            err.setMessage(message);
        }
        if(StringUtils.isNotEmpty(code)){
            err.setCode(code);
        }
        return err;
    }

    public static Error create409Error(String code, String message){
        Error err = new Error();

        err.setMessage("The resource being created already exists");
        if(StringUtils.isNotEmpty(message)){
            err.setMessage(message);
        }
        if(StringUtils.isNotEmpty(code)){
            err.setCode(code);
        }
        return err;
    }

}
