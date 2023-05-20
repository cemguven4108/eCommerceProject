package cembo.devs.ecommerce.core.utilities.exceptions;

import java.time.ZonedDateTime;

public record ProblemDetails(
        String message,
        ZonedDateTime timestamp
) {}
