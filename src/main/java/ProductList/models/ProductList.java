package ProductList.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class ProductList {

    @Id
    private int id;
    private String name;
    private int totalKcal;
    @DBRef
    private List<Product> productList;
}
