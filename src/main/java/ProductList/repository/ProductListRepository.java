package ProductList.repository;

import ProductList.models.ProductList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepository extends MongoRepository<ProductList, Integer> {

    ProductList findById(int id);
}
