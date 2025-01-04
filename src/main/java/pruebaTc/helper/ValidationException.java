package pruebaTc.helper;

import java.util.List;

public class ValidationException extends RuntimeException {
     private final List<String> errors;

    public ValidationException(List<String> errors) {
        super("Errores de validación encontrados");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
