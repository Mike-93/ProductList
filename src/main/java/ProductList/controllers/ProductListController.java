package ProductList.controllers;

import ProductList.models.Product;
import ProductList.models.ProductList;
import ProductList.services.ProductListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productList")
@Api(value = "Product list controller")
public class ProductListController {

    @Autowired
    private ProductListService service;

    @PostMapping("/new")
    @ApiOperation(value = "Сохранение списка продуктов в базу данных")
    public ResponseEntity addProductList(@RequestBody ProductList productList) {
        service.addProductList(productList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение списка продуктов по id с информацией о сумме kcal всех продуктов")
    public ResponseEntity<ProductList> getProductList(@PathVariable int id) {
        ProductList productList = service.getProductList(id);
        if (productList != null) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Добавление продукта в созданный список")
    public ResponseEntity editNews(@PathVariable int id, @RequestBody Product product) {
        final boolean added = service.addProductToProductList(id, product);
        if (added) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
