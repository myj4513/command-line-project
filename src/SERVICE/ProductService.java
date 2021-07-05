package SERVICE;

import DAO.ProductDAO;
import DTO.Product;
import DTO.User;
import java.util.*;

public class ProductService {
    public ProductDAO productDAO;

    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public void addCurrentAmount(int index){
        Product product = productDAO.getProduct(index);
        int amount = product.getCurrentAmount();
        product.setCurrentAmount(amount + product.getFundingPrice());
    }

    public void subtractCurrentAmount(int index){
        Product product = productDAO.getProduct(index);
        int amount = product.getCurrentAmount();
        product.setCurrentAmount(amount - product.getFundingPrice());
    }


}
