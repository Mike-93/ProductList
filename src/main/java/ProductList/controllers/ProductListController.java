package ProductList.controllers;

import ProductList.models.Product;
import ProductList.models.ProductList;
import ProductList.services.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductListController {

    @Autowired
    private ProductListService service;

    @PostMapping("/newProductList")
    public ResponseEntity addProductList(@RequestBody ProductList productList) {
        service.addProductList(productList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getProductList/{id}")
    public ResponseEntity<ProductList> getProductList(@PathVariable int id) {
        ProductList productList = service.getProductList(id);
        if (productList != null) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/addProductToList/{id}")
    public ResponseEntity editNews(@PathVariable int id, @RequestBody Product product) {
        final boolean added = service.addProductToProductList(id, product);
        if (added) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
