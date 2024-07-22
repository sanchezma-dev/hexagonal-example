package hex.example.application.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    public ApiResponseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public static ApiResponseException of(final String message, final HttpStatus httpStatus) {
        return new ApiResponseException(message, httpStatus);
    }
}
