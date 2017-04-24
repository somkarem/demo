package uk.gov.hmcts.todolist.app.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	private static Gson gson = new GsonBuilder().create();
	@Override
	public Response toResponse(Throwable ex) {
		
		ex.printStackTrace();
		Response.StatusType type = getStatusType(ex);
		return Response.status(type.getStatusCode())
				.build();
	}

	private Response.StatusType getStatusType(Throwable ex) {
		if (ex instanceof WebApplicationException) {
			return((WebApplicationException)ex).getResponse().getStatusInfo();
		} else if (ex instanceof  ServiceUnavailableException) {
			return Status.SERVICE_UNAVAILABLE;
		}else {
			return Status.INTERNAL_SERVER_ERROR;
		}
	}
}