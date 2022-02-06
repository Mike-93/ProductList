package ProductList.controllers;

import ProductList.models.Product;
import ProductList.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Api(value = "Product controller")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/new")
    @ApiOperation(value = "Сохранение продукта в базу данных")
    public ResponseEntity addProduct(@RequestBody Product product) {
        service.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Получение списка всех продуктов")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getAllProducts();
        if (products != null && !products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
