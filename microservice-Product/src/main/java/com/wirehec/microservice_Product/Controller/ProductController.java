package com.wirehec.microservice_Product.Controller;


import com.wirehec.microservice_Product.Controller.DTO.ProductDTO;
import com.wirehec.microservice_Product.Entity.ProductEntity;
import com.wirehec.microservice_Product.Service.Impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productDTOs = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .nombreProducto(product.getNombreProducto())
                        .categoriaProducto(product.getCategoriaProducto())
                        .precioVenta(product.getPrecioVenta())
                        .stock(product.getStock())
                        .precioCoste(product.getPrecioCoste())
                        .build()
                )
                .toList(); // Collect the stream into a list
        return ResponseEntity.ok(productDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO) {
        ProductEntity productEntity = ProductEntity.builder()
                .nombreProducto(productDTO.getNombreProducto())
                .categoriaProducto(productDTO.getCategoriaProducto())
                .precioVenta(productDTO.getPrecioVenta())
                .stock(productDTO.getStock())
                .precioCoste(productDTO.getPrecioCoste())
                .build();
        return ResponseEntity.ok(productService.saveProduct(productEntity));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductEntity productEntity = ProductEntity.builder()
                .id(id)
                .nombreProducto(productDTO.getNombreProducto())
                .categoriaProducto(productDTO.getCategoriaProducto())
                .precioVenta(productDTO.getPrecioVenta())
                .stock(productDTO.getStock())
                .precioCoste(productDTO.getPrecioCoste())
                .build();
        return ResponseEntity.ok(productService.saveProduct(productEntity));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/findProductBySupplier/{idProduct}")
    public ResponseEntity<?> findProductBySupplier(@PathVariable Long idProduct) {
        log.info("Fetching product by supplier with ID: {}", idProduct);
        return ResponseEntity.ok(productService.findProductBySupplier(idProduct));
    }
}
