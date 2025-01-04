package pruebaTc.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pruebaTc.dto.ProductDto;

@Component
public class Validaciones {

    public void validateProductDto(ProductDto productDto) {
        List<String> errors = new ArrayList<>();
        if (productDto.getProductId() == null || productDto.getProductId().isBlank()) {
            errors.add("El ID no puede estar vacío");
        }
        if (productDto.getName() == null || productDto.getName().isBlank()) {
            errors.add("El nombre no puede estar vacío");
        }
        if (productDto.getDescription() == null || productDto.getDescription().isBlank()) {
            errors.add("La descripción no puede estar vacía");
        }
        if (productDto.getPrice() <= 0) {
            errors.add("El precio debe ser mayor a 0");
        }
        if (productDto.getStock() < 0) {
            errors.add("El stock no puede ser negativo");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

 
}
