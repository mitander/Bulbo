package sysjm3.bulbo.Bulbo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WorkspaceNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WorkspaceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String workspaceNotFoundHandler(WorkspaceNotFoundException ex) {
        return ex.getMessage();
    }
}
