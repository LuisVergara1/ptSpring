package pruebaTc.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pruebaTc.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
    //Buscar Producto por su productId
    Optional<Product> findByProductId(String productId);
}
