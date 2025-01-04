package pruebaTc.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pruebaTc.dto.ProductDto;
import pruebaTc.dto.UpdateDto;
import pruebaTc.models.Product;
import pruebaTc.services.ProductServide;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServide productServide;
    
    public ProductController(ProductServide productServide) {
        this.productServide = productServide;
    }
    
    //Guardar Un producto
    @PostMapping("/create")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
            productServide.validateProductId(productDto.getProductId());
            productServide.saveProduct(productDto);
            return ResponseEntity.ok("Producto Guardado");
    }

    //Listar Todos los Productos
    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productServide.findAllProducts();
        return ResponseEntity.ok(products);
    }

    //Buscar Producto por su productId
    @GetMapping("/find/{productId}")
    public ResponseEntity<?> findProductByProductId(@PathVariable String productId) {
            Product product = productServide.findProductByProductId(productId);
            return ResponseEntity.ok(product);
    }

    //Eliminar Producto
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId) {
            productServide.deleteProduct(productId);
            return ResponseEntity.ok("Producto Eliminado");
    }


    //Actualizar Producto
    @PutMapping("/update/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable String productId, @RequestBody UpdateDto updateDto) {   
           productServide.updateProduct(updateDto, productId);
            return ResponseEntity.ok("Producto Actualizado");     
    }
}
