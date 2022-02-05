package ProductList.services;

import ProductList.models.Product;
import ProductList.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void addProduct(Product product) {
        Product newProduct = new Product();
        List<Product> productList = getAllProducts();
        if (productList.isEmpty()) {
            newProduct.setId(1);
        } else {
            newProduct.setId(productList.size() + 1);
        }
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setKcal(product.getKcal());
        repository.save(newProduct);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
