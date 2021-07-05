package VIEW;

import DTO.*;
import java.util.*;
import DAO.FundingDAO;
import java.time.format.*;

public class FundingView {
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss");

    public void showSponsor(FundingDAO fundingDAO, Product product){
        List<Funding> list = fundingDAO.getSponsor(product);
        Iterator it = list.iterator();
        while(it.hasNext()){
            int count = 0;
            Funding funding = (Funding)it.next();
            System.out.println(++count+"."+funding.getUser().getId()+"   "+funding.getTime().format(formatter));
        }
    }

    public void showFundingList(FundingDAO fundingDAO, User user){
        List<Funding> list = fundingDAO.getFundingList(user);
        Iterator it = list.iterator();
        while(it.hasNext()){
            int count = 0;
            Funding funding = (Funding)it.next();
            System.out.println(++count+"."+funding.getProduct().getName()+"   "+funding.getTime().format(formatter));
        }
    }
}
