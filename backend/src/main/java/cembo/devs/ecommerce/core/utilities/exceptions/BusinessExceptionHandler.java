package cembo.devs.ecommerce.core.utilities.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(value = {
            ProductNotFoundException.class,
            StockLimitExceededException.class
    })
    public ProblemDetails handleException(RuntimeException exception) {
        return new ProblemDetails(
                exception.getMessage(),
                ZonedDateTime.now()
        );
    }
}
