package SERVICE;

import DAO.FundingDAO;
import DTO.*;

public class FundingService {
    public FundingDAO fundingDAO;

    public FundingService(FundingDAO fundingDAO){
        this.fundingDAO = fundingDAO;
    }

    public void cancelFunding(UserService userService, ProductService productService, Funding funding){
        Product product = funding.getProduct();
        fundingDAO.removeFunding(funding);
        userService.addAccount(product.getFundingPrice());
        productService.subtractCurrentAmount(product);
    }
}
