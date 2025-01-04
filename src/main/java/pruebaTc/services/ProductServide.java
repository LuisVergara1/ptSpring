package pruebaTc.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pruebaTc.dto.ProductDto;
import pruebaTc.dto.UpdateDto;
import pruebaTc.helper.Validaciones;
import pruebaTc.models.Product;
import pruebaTc.repository.ProductRepository;

@Service
public class ProductServide {
    
    private final ProductRepository productRepository;
    private final Validaciones validaciones;
    
    public ProductServide(ProductRepository productRepository , Validaciones validaciones) {
        this.productRepository = productRepository;
        this.validaciones = validaciones;
    }

    //Guardar producto
    public void saveProduct(ProductDto productDto) {
        try {
        if (productRepository.findByProductId(productDto.getProductId()).isPresent()) {
            throw new IllegalArgumentException("El producto con el ID " + productDto.getProductId() + " ya existe.");
        }
        validaciones.validateProductDto(productDto);
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreated_at(LocalDateTime.now());
        product.setUpdated_at(LocalDateTime.now());
        productRepository.save(product);
        
    } catch (DataAccessException e) {
        throw new IllegalArgumentException("Verificar conexion a la base de datos");
    }
    }

    //Listar Todos los Productos
    public List<Product> findAllProducts() {
        try {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron productos");
        }
        return products;
        }
        catch (DataAccessException e) {
            throw new IllegalArgumentException("Verificar conexion a la base de datos");
        }
    }

    

    //Buscar Producto por su productId
    public Product findProductByProductId(String productId) {
        try {
        return productRepository.findByProductId(productId).orElseThrow(() -> new IllegalArgumentException("Producto con ID " + productId + " no encontrado"));
    }catch (DataAccessException e) {
        throw new IllegalArgumentException("Verificar conexion a la base de datos");
    }
    }

    //Actualizar Producto
    public void updateProduct(UpdateDto productDto , String productId) {
        try {
        Product product = productRepository.findByProductId(productId)
        .orElseThrow(() -> new IllegalArgumentException("Producto con ID " + productId + " no encontrado"));

        // Verificar si al menos un campo es diferente
        boolean changes = false;

        if (productDto.getName() != null && !productDto.getName().isBlank() && !productDto.getName().equals(product.getName())) {
            product.setName(productDto.getName());
            changes = true;
        }
        if (productDto.getDescription() != null && !productDto.getDescription().isBlank() && !productDto.getDescription().equals(product.getDescription())) {
            product.setDescription(productDto.getDescription());
            changes = true;
        }
        if (productDto.getPrice() > 0 && productDto.getPrice() != product.getPrice()) {
            product.setPrice(productDto.getPrice());
            changes = true;
        }
        if (productDto.getStock() != null && productDto.getStock() >= 0 && !productDto.getStock().equals(product.getStock())) {
            product.setStock(productDto.getStock());
            changes = true;
        }

        // Si no hay cambios, lanza una excepción
        if (!changes) {
            throw new IllegalArgumentException("No se Detectaron cambios en el producto. No se puede actualizar.");
        }
        product.setUpdated_at(LocalDateTime.now());
        productRepository.save(product);
    }  
        catch (DataAccessException e) {
            throw new IllegalArgumentException("Verificar conexion a la base de datos");
        }
    }

    //Eliminar Producto
    public void deleteProduct(String productId) {
        try {
       Product product = productRepository.findByProductId(productId).orElseThrow(() -> new IllegalArgumentException("Producto con ID " + productId + " no encontrado"));
       
      productRepository.delete(product);
    }catch (DataAccessException e) {
            throw new IllegalArgumentException("Verificar conexion a la base de datos");
    }
    }

    //Validar si el Codigo Producto Existe
    public void validateProductId(String productId) {
        if (productRepository.findByProductId(productId).isPresent()) {
            throw new IllegalArgumentException("El producto con el código " + productId + " ya existe.");
        }
    }
}
