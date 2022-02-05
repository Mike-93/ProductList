package ProductList.repository;

import ProductList.models.Product;
import ProductList.models.ProductList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

    Product findById(int id);
}
