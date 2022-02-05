package ProductList.services;

import ProductList.models.Product;
import ProductList.models.ProductList;
import ProductList.repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductListService {

    @Autowired
    private ProductListRepository productListRepository;

    public void addProductList(ProductList productList) {
        List<ProductList> lists = productListRepository.findAll();
        ProductList newProductList = new ProductList();
        if (lists.isEmpty()) {
            productList.setId(1);
        } else {
            productList.setId(lists.size() + 1);
        }
        newProductList.setName(productList.getName());
        productListRepository.save(newProductList);
    }

    public boolean addProductToProductList(int productListId, Product product) {
        ProductList productList = productListRepository.findById(productListId);
        if (productList != null) {
            List<Product> products;
            if (productList.getProductList().isEmpty()) {
                products = new ArrayList<>();
            } else {
                products = productList.getProductList();
            }
            products.add(product);
            productList.setProductList(products);
            productListRepository.save(productList);
            return true;
        } else {
            return false;
        }
    }

    public ProductList getProductList(int id) {
        return productListRepository.findById(id);
    }
}
