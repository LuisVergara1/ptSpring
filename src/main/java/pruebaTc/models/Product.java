package pruebaTc.models;



import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Product {
 
    @Id
    private String id;
    private String productId;
    private String name;
    private String description;
    private double price;
    private int stock;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    
}
