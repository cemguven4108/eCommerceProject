package cembo.devs.ecommerce.core.utilities.exceptions.runtimeExceptions;

public class StockLimitExceededException extends RuntimeException {

    public StockLimitExceededException(String message) {
        super(message);
    }

    public StockLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
