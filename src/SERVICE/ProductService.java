package SERVICE;

import DAO.ProductDAO;
import DTO.Product;

public class ProductService {
    public ProductDAO productDAO;

    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public void addCurrentAmount(Product product){
        int amount = product.getCurrentAmount();
        product.setCurrentAmount(amount + product.getFundingPrice());
    }

    public void subtractCurrentAmount(Product product){
        int amount = product.getCurrentAmount();
        product.setCurrentAmount(amount - product.getFundingPrice());
    }


}
