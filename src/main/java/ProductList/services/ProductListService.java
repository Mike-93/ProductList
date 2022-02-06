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
            newProductList.setId(1);
        } else {
            newProductList.setId(lists.size() + 1);
        }
        newProductList.setName(productList.getName());
        productListRepository.save(newProductList);
    }

    public boolean addProductToProductList(int productListId, Product product) {
        ProductList productList = productListRepository.findById(productListId);
        int cal = 0;
        if (productList != null) {
            List<Product> products;
            if (productList.getProductList() == null) {
                products = new ArrayList<>();
            } else {
                products = productList.getProductList();
            }
            products.add(product);
            for (Product p : products) {
                cal += p.getKcal();
            }
            productList.setTotalKcal(cal);
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
