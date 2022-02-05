package ProductList.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Product {

    @Id
    private int id;
    private String name;
    private String description;
    private int kcal;

}
