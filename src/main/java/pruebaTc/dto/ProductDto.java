package pruebaTc.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String productId;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
}
