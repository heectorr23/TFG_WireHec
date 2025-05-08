package com.wirehec.microservice_Product.Controller;


import com.wirehec.microservice_Product.Service.Impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/findProductBySupplier/{idProduct}")
    public ResponseEntity<?> findProductBySupplier(@PathVariable Long idProduct) {
        log.info("Fetching product by supplier with ID: {}", idProduct);
        return ResponseEntity.ok(productService.findProductBySupplier(idProduct));
    }
}
