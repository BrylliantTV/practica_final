package bryan.travelAPP.restController.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AirlineNotFoundException extends RuntimeException {
    public AirlineNotFoundException (String mensaje) {
        super(mensaje);
    }
}
